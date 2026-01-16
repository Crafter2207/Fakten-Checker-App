package com.fakten.checker.ui.factcheck

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fakten.checker.Screen
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.model.FactStatus
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactCheckScreen(viewModel: FactCheckViewModel = hiltViewModel(), navController: NavController) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    var inputText by remember { mutableStateOf("") }
    var isUrlInput by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Fact Check", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Enter Text:")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = isUrlInput,
                onCheckedChange = { isUrlInput = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Enter URL:")
        }
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text(if (isUrlInput) "Enter URL" else "Enter Claim") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (inputText.isNotBlank()) {
                    viewModel.checkFact(inputText, isUrlInput)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !state.isLoading
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp))
            } else {
                Text("Check Fact")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        state.error?.let {
            Text("Error: $it", color = MaterialTheme.colorScheme.error)
        }
        state.fact?.let { fact ->
            LaunchedEffect(fact) {
                val encodedStatement = URLEncoder.encode(fact.statement, StandardCharsets.UTF_8.toString())
                navController.navigate("${Screen.FactResult}/$encodedStatement")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FactCheckScreenPreview() {
    FaktenCheckerAppTheme {
        FactCheckScreen(navController = rememberNavController())
    }
}

