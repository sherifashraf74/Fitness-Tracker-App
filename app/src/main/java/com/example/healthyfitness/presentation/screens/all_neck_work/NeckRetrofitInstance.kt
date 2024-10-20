package com.example.healthyfitness.presentation.screens.all_neck_work

import com.example.healthyfitness.data.data_source.remote.retrofit.api.services.NeckExerciseApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NeckRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BackExerciseApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: NeckExerciseApiService by lazy {
        retrofit.create(NeckExerciseApiService::class.java)
    }
}
