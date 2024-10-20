package com.example.healthyfitness.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.healthyfitness.presentation.screens.common_components.Exercise
import com.example.healthyfitness.data.food_data.FoodDatabaseItem

@Dao
interface AllFitnessDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFood(allFood: List<FoodDatabaseItem>)

    @Query("SELECT * FROM food_item ")
    suspend fun getAllFood(): List<FoodDatabaseItem>

    @Query("SELECT * FROM food_item WHERE id = :id")
    suspend fun getFoodById(id: Int): FoodDatabaseItem


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllExercises(allExercises: List<Exercise>)

    @Query("SELECT * FROM exercise_item ")
    suspend fun getAllPartExercises():List<Exercise>

    @Query("SELECT * FROM exercise_item WHERE id = :id")
    suspend fun getExerciseById(id:String): Exercise
}