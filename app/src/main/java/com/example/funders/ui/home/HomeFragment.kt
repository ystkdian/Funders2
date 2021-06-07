package com.example.funders.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.funders.BaseFragment
import com.example.funders.data.UserPreferences
import com.example.funders.data.network.UserApi
import com.example.funders.data.repository.UserRepository
import com.example.funders.databinding.FragmentHomeBinding
import com.example.funders.ui.profile.ProfileViewModel
import com.example.funders.ui.signin.SignInActivity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, UserRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userPreferences = UserPreferences(requireContext())
        userPreferences.authToken.asLiveData().observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it ?: "Token is Null", Toast.LENGTH_SHORT).show()

        })
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): UserRepository {
        val token = runBlocking { userPreferences.authToken.first() }
        val api = remoteDataSource.buildApi(UserApi::class.java, token)
        return UserRepository(api)
    }

}