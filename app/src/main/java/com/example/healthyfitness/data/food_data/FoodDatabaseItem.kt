package com.example.healthyfitness.data.food_data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("food_item")
data class FoodDatabaseItem (
    val carbohydrates: String,
    val carbohydrates_sugar: String,
    val energy: Int,
    val fat: String,
    val fat_saturated: String,
    val fiber: String,
    @PrimaryKey val id: Int,
    val image: String,
    val name: String,
    val protein: String,
    val sodium: String,
)
