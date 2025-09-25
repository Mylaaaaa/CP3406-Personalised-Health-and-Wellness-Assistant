package com.example.personalisedhealthapp.data.repository

import com.example.personalisedhealthapp.data.model.MealItem

interface WellnessRepository {
    fun getTodayMeals(): List<MealItem>
    fun getDailyProgress(): Triple<Float, Float, Float>
}

class InMemoryWellnessRepository : WellnessRepository {
    override fun getTodayMeals() = listOf(
        MealItem("Oatmeal + Banana", 320),
        MealItem("Chicken Salad", 480),
        MealItem("Greek Yogurt", 150)
    )

    override fun getDailyProgress() = Triple(0.62f, 0.75f, 0.40f)
}