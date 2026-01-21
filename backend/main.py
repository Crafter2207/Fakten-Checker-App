from fastapi import FastAPI, HTTPException
from bs4 import BeautifulSoup
import requests
import litellm
import os
from pydantic import BaseModel

app = FastAPI()

# Ollama configuration (optional)
OLLAMA_BASE_URL = os.getenv("OLLAMA_BASE_URL", "http://localhost:11434")
OLLAMA_MODEL = os.getenv("OLLAMA_MODEL", "llama3.2")

class AnalyzeRequest(BaseModel):
    url: str
    provider: str = "gemini/gemini-1.5-flash"

def get_llm_response(prompt: str, provider: str = "openai/gpt-3.5-turbo") -> str:
    """
    Get LLM response using Ollama (if available) or the specified provider.
    """
    # Try Ollama first if provider starts with "ollama/"
    if provider.startswith("ollama/"):
        ollama_model = provider.replace("ollama/", "")
        try:
            result: dict = litellm.completion(
                model=f"ollama/{ollama_model}",
                base_url=OLLAMA_BASE_URL,
                messages=[{"role": "user", "content": prompt}],
                timeout=60
            )
            # Handle both streaming and non-streaming responses
            if isinstance(result, dict) and "choices" in result:
                return result["choices"][0]["message"]["content"]
        except Exception as ollama_error:
            # Check if it's a connection error (Ollama not running)
            if "Connection" in str(ollama_error) or "timeout" in str(ollama_error).lower():
                pass  # Fall through to next provider
            else:
                raise HTTPException(status_code=500, detail=f"Ollama error: {str(ollama_error)}")
    
    # Handle other providers (OpenAI, Gemini, Anthropic)
    try:
        result: dict = litellm.completion(
            model=provider,
            messages=[{"role": "user", "content": prompt}],
            timeout=60
        )
        # Handle both streaming and non-streaming responses
        if isinstance(result, dict) and "choices" in result:
            return result["choices"][0]["message"]["content"]
        raise HTTPException(status_code=500, detail="Invalid response format from LLM")
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"LLM error: {str(e)}")

@app.get("/")
def read_root():
    return {"message": "Welcome to the Fakten Checker API"}

@app.get("/health")
def health_check():
    """Health check endpoint"""
    return {"status": "healthy", "ollama_url": OLLAMA_BASE_URL}

@app.post("/analyze")
def analyze_url(request: AnalyzeRequest):
    """
    Analyze a URL and check facts using LLM.
    This endpoint matches the Android app's MyBackendApi interface.
    """
    url = request.url
    provider = request.provider
    
    try:
        # Scrape the website
        response = requests.get(url, timeout=10)
        response.raise_for_status()
        soup = BeautifulSoup(response.text, 'html.parser')
        text = soup.get_text()

        # Use LLM to analyze the content
        prompt = f"""Analysiere den Inhalt der folgenden URL und beantworte die Frage: 
        "Ist der Inhalt dieser Seite glaubwürdig und korrekt?"

URL: {url}

Inhalt (Auszug):
{text[:3000]}

Antworte in diesem Format:
STATUS: [WAHR|FALSCH|TEILWEISE WAHR|UNBEWIESEN]
ANALYSE: [Detaillierte Erklärung der Analyse]
QUELLEN: [Liste der gefundenen Quellen, falls vorhanden]"""

        answer = get_llm_response(prompt, provider)

        return {
            "analysis": answer,
            "status": "analyzed",
            "message": "Analysis complete"
        }
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@app.post("/check_fact")
def check_fact(url: str, claim: str):
    """
    Legacy endpoint for fact checking with a specific claim.
    """
    try:
        # Scrape the website
        response = requests.get(url, timeout=10)
        response.raise_for_status()
        soup = BeautifulSoup(response.text, 'html.parser')
        text = soup.get_text()

        # Use LLM to check the fact
        prompt = f"""Analyze the following claim against the website content. 
Determine if the claim is TRUE or FALSE based on the text.

Claim: "{claim}"

Website content (excerpt):
{text[:2000]}

Respond in this format:
VERDICT: [TRUE|FALSE|PARTIALLY TRUE|INSUFFICIENT INFO]
EXPLANATION: [Brief explanation of your reasoning]"""

        answer = get_llm_response(prompt)

        return {
            "url": url, 
            "claim": claim, 
            "result": answer
        }
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

