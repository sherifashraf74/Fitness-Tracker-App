package com.example.healthyfitness.data.data_source.remote.retrofit.api.responses

data class SignUpResponse(
    val status: String,
    val token: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val photo: String
)