package com.fakten.checker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.model.FactStatus
import com.fakten.checker.ui.dashboard.DashboardScreen
import com.fakten.checker.ui.factcheck.FactCheckScreen
import com.fakten.checker.ui.factcheck.FactResultScreen
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.Date

// Define routes
object Screen {
    const val Dashboard = "dashboard"
    const val FactCheck = "factCheck"
    const val FactResult = "factResult"
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
        composable(Screen.Dashboard) {
            DashboardScreen(navController = navController)
        }
        composable(Screen.FactCheck) {
            FactCheckScreen(navController = navController)
        }
        composable(
            route = "${Screen.FactResult}/{encodedFactStatement}",
            arguments = listOf(
                navArgument("encodedFactStatement") { type = androidx.navigation.NavType.StringType }
            )
        ) { backStackEntry ->
            val encodedStatement = backStackEntry.arguments?.getString("encodedFactStatement") ?: ""
            val decodedStatement = try {
                URLDecoder.decode(encodedStatement, StandardCharsets.UTF_8.toString())
            } catch (e: Exception) {
                encodedStatement
            }
            val fact = Fact(
                statement = decodedStatement,
                status = FactStatus.UNPROVEN,
                sources = emptyList(),
                checkDate = Date()
            )
            FactResultScreen(navController = navController, fact = fact)
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

