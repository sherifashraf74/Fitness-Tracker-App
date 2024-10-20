package com.example.healthyfitness.data.food_data

data class AllFood(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<FoodItem>
)