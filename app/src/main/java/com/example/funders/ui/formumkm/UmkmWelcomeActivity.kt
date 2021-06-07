package com.example.funders.ui.formumkm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.funders.databinding.ActivityUmkmWelcomeBinding
import com.example.funders.ui.signup.ChooseRoleActivity

class UmkmWelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUmkmWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUmkmWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ChooseRoleActivity::class.java)
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, UmkmFormActivity::class.java)
            startActivity(intent)
        }
    }
}