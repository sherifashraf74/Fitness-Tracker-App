package com.example.healthyfitness.presentation.screens.foods

import android.util.Log
import com.example.healthyfitness.data.food_data.FoodDatabaseItem
import com.example.healthyfitness.data.food_data.FoodItem

fun List<FoodItem>.toDatabaseItems(): List<FoodDatabaseItem> {
    return this.mapNotNull { foodItem ->
        try {
            FoodDatabaseItem(
                carbohydrates = foodItem.carbohydrates ?: "0.0", // Provide a default value if null
                carbohydrates_sugar = foodItem.carbohydrates_sugar ?: "0.0",
                energy = foodItem.energy ?: 0,
                fat = foodItem.fat ?: "0.0",
                fat_saturated = foodItem.fat_saturated ?: "0.0",
                fiber = foodItem.fiber ?: "0.0",
                id = foodItem.id ?: -1, // Handle id appropriately
                image = foodItem.image?.image ?: "", // Safe call
                name = foodItem.name ?: "Unknown", // Default name
                protein = foodItem.protein ?: "0.0",
                sodium = foodItem.sodium ?: "0.0"
            )
        } catch (e: Exception) {
            // Log the error if mapping fails
            Log.e("MappingError", "Error mapping food item: $foodItem, ${e.message}")
            null // Skip this item if there's an error
        }
    }
}
