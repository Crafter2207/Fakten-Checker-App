package com.fakten.checker.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fakten.checker.ui.theme.FaktenCheckerAppTheme

@Composable
fun DashboardScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Dashboard")
        Spacer(modifier = Modifier.height(16.dp))
        // TODO: Add Search Field
        // TODO: Add List of currently checked topics
        // TODO: Add Learning modules
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    FaktenCheckerAppTheme {
        DashboardScreen()
    }
}
