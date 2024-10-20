package com.example.healthyfitness.data.data_source.remote.retrofit.api.services

import com.example.healthyfitness.presentation.screens.common_components.Exercise
import retrofit2.http.GET
import retrofit2.http.Headers

interface CardioExerciseApiService {

        companion object {
            const val BASE_URL = "https://exercisedb.p.rapidapi.com/"
        }

        @Headers(
            "x-rapidapi-host: exercisedb.p.rapidapi.com",
            "x-rapidapi-key: a4ec8cc140msh0eaf172ad097e1ep13fea6jsnc8bb82525ab7"  // Replace with your actual RapidAPI key
        )
        @GET("exercises/bodyPart/cardio?limit=15&offset=0")
        suspend fun getExercises(): List<Exercise>

    @GET("exercises/{id}")
    suspend fun getExerciseById(id: String): Exercise
}