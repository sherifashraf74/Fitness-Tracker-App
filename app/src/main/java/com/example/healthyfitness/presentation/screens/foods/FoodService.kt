package com.example.healthyfitness.presentation.screens.foods

import com.example.healthyfitness.data.food_data.AllFood
import retrofit2.http.GET

interface FoodService {
    @GET("ingredientinfo/?limit=44")
    suspend fun getAllFood (): AllFood
}