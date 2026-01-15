package com.fakten.checker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.model.FactStatus
import com.fakten.checker.ui.dashboard.DashboardScreen
import com.fakten.checker.ui.factcheck.FactCheckScreen
import com.fakten.checker.ui.factcheck.FactResultScreen
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

// Define routes as sealed class for type safety
sealed class Screen(val route: String) {
    data object Dashboard : Screen("dashboard")
    data object FactCheck : Screen("factCheck")
    data class FactResult(val fact: Fact) : Screen("factResult/{encodedFactStatement}") {
        // Custom route pattern to include the encoded fact statement
        fun getRoute(fact: Fact): String {
            val encodedFactStatement = URLEncoder.encode(fact.statement, StandardCharsets.UTF_8.toString())
            return "factResult/$encodedFactStatement"
        }
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FaktenCheckerAppTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard
    ) {
        composable<Screen.Dashboard> {
            DashboardScreen(navController = navController)
        }
        composable<Screen.FactCheck> {
            FactCheckScreen(navController = navController)
        }
        composable<Screen.FactResult> {
            val args = it.arguments?.getString("encodedFactStatement")
            val decodedStatement = args?.let {
                URLEncoder.encode(it, StandardCharsets.UTF_8.toString())
            } // Basic decoding, assumes statement was URL-encoded
            // In a real app, you'd likely pass a more robust object or ID and fetch details separately
            val dummyFact = if (decodedStatement != null) {
                 com.fakten.checker.domain.model.Fact(
                    statement = decodedStatement, 
                    status = com.fakten.checker.domain.model.FactStatus.UNPROVEN, // Dummy data
                    sources = emptyList(), // Dummy data
                    checkDate = java.util.Date() // Dummy data
                )
            } else {
                null
            }
            FactResultScreen(navController = navController, fact = dummyFact)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FaktenCheckerAppTheme {
        DashboardScreen(navController = rememberNavController())
    }
}
