package com.fakten.checker.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.navigation.compose.rememberNavController
import com.fakten.checker.domain.model.LearningModule
import com.fakten.checker.domain.model.LearningModuleType
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    DashboardScreenContent(
        state = state,
        navController = navController,
        viewModel = viewModel
    )
}

@Composable
fun DashboardScreenContent(
    state: DashboardState,
    navController: NavController,
    viewModel: DashboardViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Dashboard", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = state.searchQuery,
                    onValueChange = { viewModel.onSearchQueryChanged(it) },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Fakt prüfen...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        navController.navigate("factCheck")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Start Fact Check")
                }
                Spacer(modifier = Modifier.height(16.dp))

                LearningModuleList(learningModules = state.filteredModules)
            }
        }
    }
}

@Composable
fun LearningModuleList(learningModules: List<LearningModule>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(learningModules) { module ->
            LearningModuleItem(module = module)
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
        DashboardScreenContent(
            state = DashboardState(
                learningModules = listOf(
                    LearningModule(
                        title = "Erkenne Falschinformationen",
                        description = "Lerne, wie man Falschinformationen im Internet erkennt und überprüft.",
                        type = LearningModuleType.QUIZ
                    )
                ),
                isLoading = false
            ),
            navController = rememberNavController()
        )
    }
}
