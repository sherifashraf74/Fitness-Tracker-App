package com.example.healthyfitness.presentation.screens.foods

import android.util.Log
import com.example.healthyfitness.data.food_data.FoodDatabaseItem
import com.example.healthyfitness.data.food_data.FoodItem
import com.example.healthyfitness.data.food_data.Image

fun List<FoodDatabaseItem>.toFoodItems(): List<FoodItem> {
    return this.mapNotNull { databaseItem ->
        try {
            FoodItem(
                carbohydrates = databaseItem.carbohydrates, // Convert string to Double
                carbohydrates_sugar = databaseItem.carbohydrates_sugar,
                energy = databaseItem.energy,
                fat = databaseItem.fat, // Convert string to Double
                fat_saturated = databaseItem.fat_saturated,
                fiber = databaseItem.fiber,
                id = databaseItem.id,
                image = Image(id= databaseItem.id,image = databaseItem.image),
                name = databaseItem.name,
                protein = databaseItem.protein,
                sodium = databaseItem.sodium
            )
        } catch (e: Exception) {
            // Log the error if mapping fails
            Log.e("MappingError", "Error mapping database item: $databaseItem, ${e.message}")
            null // Skip this item if there's an error
        }
    }
}
