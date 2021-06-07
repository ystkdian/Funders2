package com.example.funders.data.responses

data class LoginResponse(
    val access_token: String,
    val expires_in: Int,
    val status: String,
    val user: User
)