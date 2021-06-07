package com.example.funders.data.network

import com.example.funders.data.responses.LoginResponse
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    suspend fun getUser(): LoginResponse
}