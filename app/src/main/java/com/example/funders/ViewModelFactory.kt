package com.example.funders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funders.data.repository.AuthRepository
import com.example.funders.data.repository.BaseRepository
import com.example.funders.ui.AuthViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository : BaseRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}