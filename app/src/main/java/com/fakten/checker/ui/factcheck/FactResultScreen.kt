package com.fakten.checker.ui.factcheck

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.model.FactStatus
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme
import java.util.Date

@Composable
fun FactResultScreen(
    navController: NavController,
    fact: Fact?
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

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.popBackStack()
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
            Text("Status: ${fact.status.name}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Statement: ${fact.statement}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Sources: ${fact.sources.joinToString(", ")}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FactResultScreenPreview() {
    FaktenCheckerAppTheme {
        val dummyFact = Fact(
            statement = "This is a dummy statement.",
            status = FactStatus.CONFIRMED,
            sources = listOf("Source 1", "Source 2"),
            checkDate = Date()
        )
        FactResultScreen(navController = rememberNavController(), fact = dummyFact)
    }
}

