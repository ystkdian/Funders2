package com.example.funders.data.network

import com.example.funders.data.responses.User
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header

interface UserApi {
    @GET("api/auth/get_user_profile")
    fun getUser(
        @Header("Authorization") token: String,
        @Field("name") name: String,
        @Field("email") email: String,
    ): User
}