package com.example.healthyfitness.presentation.screens.all_cardio_work

import com.example.healthyfitness.data.data_source.remote.retrofit.api.services.CardioExerciseApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CardioRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BackExerciseApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CardioExerciseApiService by lazy {
        retrofit.create(CardioExerciseApiService::class.java)
    }
}
