package com.example.funders.data.repository

import com.example.funders.data.network.AuthApi
import com.example.funders.data.network.UserApi

class UserRepository(
    private val api: UserApi
) : BaseRepository() {

    suspend fun getUser() = safeApiCall {
        api.getUser()
    }

}