package com.example.healthyfitness.presentation.screens.all_shoulders_work

import com.example.healthyfitness.data.data_source.remote.retrofit.api.services.ShouldersExerciseApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ShouldersRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BackExerciseApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ShouldersExerciseApiService by lazy {
        retrofit.create(ShouldersExerciseApiService::class.java)
    }
}
