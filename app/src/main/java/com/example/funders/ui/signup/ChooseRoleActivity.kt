package com.example.funders.ui.signup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.funders.databinding.ActivityChooseRoleBinding
import com.example.funders.ui.formumkm.UmkmWelcomeActivity
import com.example.funders.ui.forminvestor.InvestorWelcomeActivity

class ChooseRoleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseRoleBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChooseRoleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnInvestor.setOnClickListener{
            val intent = Intent(this, InvestorWelcomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnUmkm.setOnClickListener{
            val intent = Intent(this, UmkmWelcomeActivity::class.java)
            startActivity(intent)
        }

    }
}