package com.example.healthyfitness.data.data_source.remote.retrofit.api.services

import com.example.healthyfitness.data.data_source.remote.retrofit.api.requests.LogInRequest
import com.example.healthyfitness.data.data_source.remote.retrofit.api.requests.SignUpRequest
import com.example.healthyfitness.data.data_source.remote.retrofit.api.responses.LoginResponse
import com.example.healthyfitness.data.data_source.remote.retrofit.api.responses.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    @POST("signup")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>

    @POST("login")
    suspend fun logIn(@Body logInRequest: LogInRequest): Response<LoginResponse>

}