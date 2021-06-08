package com.example.funders.ui.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.funders.BaseActivityBaseFragment
import com.example.funders.data.network.AuthApi
import com.example.funders.data.network.Resource
import com.example.funders.data.repository.AuthRepository
import com.example.funders.databinding.ActivitySignInBinding
import com.example.funders.enable
import com.example.funders.startNewActivity
import com.example.funders.ui.AuthViewModel
import com.example.funders.ui.MainActivity
import com.example.funders.ui.signup.SignUpActivity
import com.example.funders.visible
import kotlinx.coroutines.launch

class SignInActivity : BaseActivityBaseFragment<AuthViewModel, ActivitySignInBinding, AuthRepository>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding.loading.visible(false)
        binding.btnSignIn.enable(true)

        binding.navigateToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        viewModel.loginResponse.observe(this, Observer {
            binding.loading.visible(false)
            when(it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        userPreferences.saveAuthToken(it.value.access_token)
                        startNewActivity(MainActivity::class.java)
                    }
                }
                is Resource.Failure -> {
                    Toast.makeText(applicationContext, "Yah, gagal masuk nih:(", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.inputEmail.addTextChangedListener {

        }
        binding.btnSignIn.setOnClickListener {
            val email = binding.inputEmail.text.toString().trim()
            val password = binding.inputPass.text.toString().trim()
            binding.loading.visible(true)
            viewModel.login(email, password)

        }

    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getBinding(inflater: LayoutInflater) = ActivitySignInBinding.inflate(layoutInflater)

    override fun getRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))
}