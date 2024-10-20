package com.example.healthyfitness.presentation.screens.home_page1_screen.model

import androidx.annotation.StringRes
import com.example.healthyfitness.R

enum class ExerciseType {
    WALKING, CYCLING, SWIMMING
}

data class Exercise(
    val type: ExerciseType,
    val value: Int,
    val timestamp: Long
)





//data class FitnessActivity(
//    val type: ActivityType,
//    val value: String,
//    unit: String,
//    isActive: Boolean,
//    onStart: () -> Unit,
//    onStop: () -> Unit,
//    onRetry: () -> Unit
//)
//
//enum class ActivityType(val label: Int, val iconImg: Int) {
//    Walking(R.string.fitness_activity_walking, R.drawable.footsteps_outline),
//    Cycling(R.string.fitness_activity_cycling, R.drawable.ic_bicycle_solid_icon),
//    Workout(R.string.fitness_activity_workout, R.drawable.ic_dumbbell_icon),
//    Swimming(R.string.fitness_activity_swimming, R.drawable.ic_swimmer_icon)
//}