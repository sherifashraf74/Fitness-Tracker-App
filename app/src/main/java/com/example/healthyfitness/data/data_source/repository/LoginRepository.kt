package com.example.healthyfitness.data.data_source.repository

import com.example.healthyfitness.data.data_source.remote.retrofit.api.services.ApiService
import com.example.healthyfitness.data.data_source.remote.retrofit.api.requests.LogInRequest
import com.example.healthyfitness.data.data_source.remote.retrofit.api.responses.LoginResponse

class LoginRepository(private val authApi: ApiService) {
    suspend fun logIn(email: String, password: String): Result<LoginResponse> {
        return try {
            val logResponse = authApi.logIn(LogInRequest(email,password))
            if (logResponse.isSuccessful) {
                Result.success(logResponse.body()!!)
            } else {
                Result.failure(Exception("Sign up failed: ${logResponse.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}