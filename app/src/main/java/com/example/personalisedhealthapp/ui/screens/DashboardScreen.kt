package com.example.personalisedhealthapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    // Scaffold with top bar and scrollable content
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text("Wellness Dashboard") }) }
    ) { inner ->
        Column(
            Modifier
                .padding(inner)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Today’s Progress", style = MaterialTheme.typography.titleMedium)
            ProgressCard("Fitness (Steps)", 0.62f, "6,200 / 10,000")
            ProgressCard("Nutrition (Calories)", 0.75f, "1,500 / 2,000 kcal")
            ProgressCard("Mindfulness (Minutes)", 0.40f, "8 / 20 min")
        }
    }
}

@Composable
fun ProgressCard(title: String, value: Float, subtitle: String) {
    ElevatedCard {
        Column(Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            LinearProgressIndicator(progress = { value }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(subtitle)
                Text("${(value * 100).toInt()}%")
            }
        }
    }
}
