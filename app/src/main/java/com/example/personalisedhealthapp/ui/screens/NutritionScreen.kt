package com.example.personalisedhealthapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.personalisedhealthapp.data.model.MealItem

import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NutritionScreen(
    meals: List<MealItem>,
    modifier: Modifier = Modifier
) {
    var input by remember { mutableStateOf("") }

    // Scaffold with top bar and meal tracking content
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text("Nutrition") }) }
    ) { inner ->
        Column(
            modifier
                .padding(inner)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Add a meal", style = MaterialTheme.typography.titleMedium)

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("e.g., Avocado toast") }
                )
                Button(onClick = { /* TODO: Add meal to list */ }) {
                    Text("Add")
                }
            }

            HorizontalDivider()

            Text("Today’s Meals", style = MaterialTheme.typography.titleMedium)

            // Display a list of meals with calories
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(meals) { m ->
                    ListItem(
                        headlineContent = { Text(m.name) },
                        supportingContent = { Text("${m.kcal} kcal") }
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}
