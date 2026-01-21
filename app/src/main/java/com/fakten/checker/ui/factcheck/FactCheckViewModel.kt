package com.fakten.checker.ui.factcheck

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fakten.checker.domain.usecase.CheckFactUseCase
import com.fakten.checker.domain.model.Fact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

// Definiert den Zustand der gesamten UI
data class FactCheckScreenState(
    val uiState: FactCheckUiState = FactCheckUiState.Empty,
    val selectedProvider: String = "gemini/gemini-1.5-flash",
    val availableProviders: List<String> = listOf("gemini/gemini-1.5-flash", "openai/gpt-4o", "anthropic/claude-3-sonnet")
)

// Definiert nur den Zustand des API-Ergebnisses
sealed interface FactCheckUiState {
    object Loading : FactCheckUiState
    data class Success(val fact: Fact) : FactCheckUiState
    data class Error(val message: String) : FactCheckUiState
    object Empty : FactCheckUiState
}

@HiltViewModel
class FactCheckViewModel @Inject constructor(
    private val checkFactUseCase: CheckFactUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(FactCheckScreenState())
    val screenState: StateFlow<FactCheckScreenState> = _screenState.asStateFlow()

    // Event, um den Provider zu wechseln
    fun onProviderSelected(provider: String) {
        _screenState.update { it.copy(selectedProvider = provider) }
    }

    // Event, um den Faktencheck zu starten
    fun checkFact(url: String) {
        viewModelScope.launch {
            _screenState.update { it.copy(uiState = FactCheckUiState.Loading) }
            try {
                // Übergibt den aktuell ausgewählten Provider
                val fact = checkFactUseCase.execute(url, _screenState.value.selectedProvider)
                _screenState.update { it.copy(uiState = FactCheckUiState.Success(fact)) }
            } catch (e: Exception) {
                _screenState.update { it.copy(uiState = FactCheckUiState.Error(e.message ?: "Unknown error")) }
            }
        }
    }
}
