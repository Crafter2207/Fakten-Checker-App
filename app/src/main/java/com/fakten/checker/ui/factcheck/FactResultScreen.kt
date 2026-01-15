package com.fakten.checker.ui.factcheck

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme

@Composable
fun FactResultScreen(
    navController: NavController,
    fact: Fact? // Accept the fact data as a parameter
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Fact Check Result", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        if (fact != null) {
            FactResultDisplay(fact = fact)
        } else {
            Text("No fact data available.")
        }

        Spacer(modifier = Modifier.weight(1f)) // Push button to the bottom

        Button(
            onClick = {
                navController.popBackStack() // Go back to the previous screen (likely FactCheckScreen)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Done")
        }
    }
}

@Composable
fun FactResultDisplay(fact: Fact) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Status: ${fact.status}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Statement: ${fact.statement}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Sources: ${fact.sources.joinToString(", ")}")
            // TODO: Format checkDate appropriately
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FactResultScreenPreview() {
    FaktenCheckerAppTheme {
        // Preview requires a dummy Fact object and NavController
        val dummyFact = Fact(
            statement = "This is a dummy statement.",
            status = FactStatus.CONFIRMED,
            sources = listOf("Source 1", "Source 2"),
            checkDate = java.util.Date()
        )
        // A dummy NavController can be created for preview purposes if needed, but often it's omitted if the preview focuses on UI elements.
        FactResultScreen(navController = NavController(androidx.compose.ui.platform.LocalContext.current), fact = dummyFact)
    }
}
