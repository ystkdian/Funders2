package com.example.funders.data.repository

import com.example.funders.data.network.UserApi

class UserRepository(
    private val api: UserApi
) : BaseRepository() {

    suspend fun getUser(
        token: String,
        name: String,
        email: String
    ) = safeApiCall {
        api.getUser(token, name, email)
    }
}
