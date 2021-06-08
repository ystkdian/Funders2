package com.example.funders.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funders.data.network.Resource
import com.example.funders.data.repository.UserRepository
import com.example.funders.data.responses.User
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
): ViewModel() {

    private val _user: MutableLiveData<Resource<User>> = MutableLiveData()
    val user: LiveData<Resource<User>>
        get() = _user

    fun getUser(token: String, name: String, email: String) = viewModelScope.launch {
        _user.value = repository.getUser(token, name, email)
    }
}