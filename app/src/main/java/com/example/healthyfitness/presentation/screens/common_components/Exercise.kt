package com.example.healthyfitness.presentation.screens.common_components

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("exercise_item")
data class Exercise(

    @PrimaryKey val id: String,
    val name: String,
    val target: String,
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String
)
