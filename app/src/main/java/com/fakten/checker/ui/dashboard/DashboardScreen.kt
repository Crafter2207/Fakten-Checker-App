package com.fakten.checker.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.fakten.checker.domain.model.LearningModule
import com.fakten.checker.domain.model.LearningModuleType
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = hiltViewModel(), navController: NavController) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Dashboard", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
                // TODO: Add Search Field
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        navController.navigate("factCheck") // Navigate to the fact check screen
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Start Fact Check")
                }
                Spacer(modifier = Modifier.height(16.dp))

                LearningModuleList(learningModules = state.learningModules)
            }
        }
    }
}

@Composable
fun LearningModuleList(learningModules: List<LearningModule>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(learningModules) {
            module -> LearningModuleItem(module = module)
        }
    }
}

@Composable
fun LearningModuleItem(module: LearningModule) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = module.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = module.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    FaktenCheckerAppTheme {
        // For preview purposes, we create a dummy NavController or omit it if not essential for the preview.
        // Here, we'll omit it for simplicity, assuming the preview focuses on UI layout.
        // If navigation actions were critical for the preview, a NavHost setup would be needed.
        DashboardScreen(navController = NavController(LocalContext.current)) // Provide a dummy NavController for preview
    }
}
