package com.example.personalisedhealthapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.personalisedhealthapp.data.model.MealItem
import com.example.personalisedhealthapp.ui.screens.DashboardScreen
import com.example.personalisedhealthapp.ui.screens.MindfulnessScreen
import com.example.personalisedhealthapp.ui.screens.NutritionScreen
import com.example.personalisedhealthapp.ui.theme.PersonalisedHealthAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalisedHealthAppTheme {
                AppShell()
            }
        }
    }
}

enum class Tab(val label: String /*, val icon: ImageVector? = null */) {
    Dashboard("Dashboard"),
    Nutrition("Nutrition"),
    Mind("Mind")
}

@Composable
fun AppShell() {
    var tab by remember { mutableStateOf(Tab.Dashboard) }

    Scaffold(
        bottomBar = {
            NavigationBar {

                Tab.entries.forEach {
                    NavigationBarItem(
                        selected = tab == it,
                        onClick = { tab = it },
                        icon = {},                     // 图标可后续加
                        label = { Text(it.label) }
                    )
                }
            }
        }
    ) { innerPadding ->

        when (tab) {
            Tab.Dashboard -> DashboardScreen(modifier = Modifier.padding(innerPadding))
            Tab.Nutrition -> NutritionScreen(
                meals = listOf(
                    MealItem("Oatmeal + Banana", 320),
                    MealItem("Chicken Salad", 480),
                    MealItem("Greek Yogurt", 150)
                ),
                modifier = Modifier.padding(innerPadding)
            )
            Tab.Mind -> MindfulnessScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}
