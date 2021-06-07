package com.example.funders.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funders.data.network.Resource
import com.example.funders.data.repository.UserRepository
import com.example.funders.data.responses.LoginResponse
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: UserRepository
): ViewModel() {

    private val _user: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val user: LiveData<Resource<LoginResponse>>
        get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = Resource.Loading
        _user.value = repository.getUser()
    }
}