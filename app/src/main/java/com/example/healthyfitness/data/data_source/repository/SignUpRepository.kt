package com.example.healthyfitness.data.data_source.repository

import com.example.healthyfitness.data.data_source.remote.retrofit.api.services.ApiService
import com.example.healthyfitness.data.data_source.remote.retrofit.api.requests.SignUpRequest
import com.example.healthyfitness.data.data_source.remote.retrofit.api.responses.SignUpResponse

class SignUpRepository(private val authApi: ApiService) {
    suspend fun signUp(firstName: String, lastName: String, email: String, password: String): Result<SignUpResponse> {
        return try {
            val response = authApi.signUp(SignUpRequest(firstName, lastName, email, password))
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Sign up failed: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}