package com.example.funders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.funders.data.UserPreferences
import com.example.funders.data.network.RemoteDataSource
import com.example.funders.data.repository.BaseRepository

abstract class BaseActivityBaseFragment<VM: ViewModel, B: ViewBinding, R: BaseRepository> : AppCompatActivity() {

    protected lateinit var userPreferences: UserPreferences
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    protected val remoteDataSource = RemoteDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userPreferences = UserPreferences(this)
        binding = getBinding(layoutInflater)
        val factory = ViewModelFactory(getRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())

        setContentView(binding.root)
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getBinding(inflater: LayoutInflater): B

    abstract fun getRepository(): R
}