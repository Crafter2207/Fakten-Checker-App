package com.fakten.checker.ui.factcheck

import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // Using Material 3 components
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme

@OptIn(ExperimentalMaterial3Api::class) // Enable experimental Material 3 features
@Composable
fun FactCheckScreen() {
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
                // TODO: Handle fact check submission
                println("Submitting: $inputText")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Check Fact")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FactCheckScreenPreview() {
    FaktenCheckerAppTheme {
        FactCheckScreen()
    }
}
