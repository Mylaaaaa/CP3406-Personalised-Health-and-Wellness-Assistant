package com.example.personalisedhealthapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MindfulnessScreen(modifier: Modifier = Modifier) {
    var running by remember { mutableStateOf(false) }
    var mood by remember { mutableStateOf<String?>(null) }

    // Scaffold with top bar and mindfulness content
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text("Mindfulness") }) }
    ) { inner ->
        Column(
            modifier
                .padding(inner)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Guided Breathing", style = MaterialTheme.typography.titleMedium)
            Button(onClick = { running = !running }, modifier = Modifier.fillMaxWidth()) {
                Text(if (running) "Stop" else "Start 3-min Session")
            }

            // Animated breathing session card
            AnimatedVisibility(visible = running) {
                ElevatedCard {
                    Column(Modifier.padding(16.dp)) {
                        Text("Session Running…")
                        Spacer(Modifier.height(8.dp))
                        LinearProgressIndicator(progress = { 0.4f }, modifier = Modifier.fillMaxWidth())
                        Spacer(Modifier.height(4.dp))
                        Text("01:48 remaining")
                    }
                }
            }

            HorizontalDivider()

            Text("Mood Check-in")
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("😀", "😐", "😟").forEach { face ->
                    AssistChip(onClick = { mood = face }, label = { Text(face) })
                }
            }
            Text("Selected: ${mood ?: "None"}")
        }
    }
}
