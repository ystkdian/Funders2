package com.example.funders.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.funders.R
import com.example.funders.databinding.ActivitySignUpBinding
import com.example.funders.ui.signin.SignInActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnNext.setOnClickListener{
            val intent = Intent(this, ChooseRoleActivity::class.java)
            startActivity(intent)
        }

        binding.navigateToSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

    }
}