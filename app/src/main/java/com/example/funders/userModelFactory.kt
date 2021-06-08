package com.example.funders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.funders.data.repository.BaseRepository
import com.example.funders.data.repository.UserRepository
import com.example.funders.ui.profile.ProfileViewModel

@Suppress("UNCHECKED_CAST")
class userModelFactory(
    private val repository : BaseRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> ProfileViewModel(repository as UserRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}