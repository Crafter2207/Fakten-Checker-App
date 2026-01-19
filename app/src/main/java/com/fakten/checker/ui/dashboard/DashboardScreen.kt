package com.fakten.checker.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
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
    navController: NavController,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    // Der "Stateful" Part: Holt Daten von Hilt
    val state by viewModel.state.collectAsStateWithLifecycle()

    DashboardContent(
        state = state,
        onStartFactCheck = { navController.navigate("factCheck") }
    )
}

@Composable
fun DashboardContent(
    state: DashboardState,
    onStartFactCheck: () -> Unit
) {
    // Der "Stateless" Part: Zeichnet nur die UI
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Dashboard",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Fakt prüfen...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onStartFactCheck,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Start Fact Check")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Lernmodule",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Hier rufen wir die Liste auf
                LearningModuleList(learningModules = state.learningModules)
            }
        }
    }
}

@Composable
fun LearningModuleList(learningModules: List<LearningModule>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(learningModules) { module ->
            LearningModuleItem(module = module)
        }
    }
}

@Composable
fun LearningModuleItem(module: LearningModule) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
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
        DashboardContent(
            state = DashboardState(
                learningModules = listOf(
                    // Wir entfernen die "1" und "2" am Anfang, falls dein Model keine ID im Konstruktor hat
                    // Und wir nutzen die korrekte Enum-Referenz
                    LearningModule(
                        title = "Fake News erkennen",
                        description = "Lerne die Grundlagen",
                        type = LearningModuleType.QUIZ
                    ),
                    LearningModule(
                        title = "Quellen prüfen",
                        description = "Wie checke ich Quellen?",
                        type = LearningModuleType.VIDEO
                    )
                ),
                isLoading = false
            ),
            onStartFactCheck = {}
        )
    }
}