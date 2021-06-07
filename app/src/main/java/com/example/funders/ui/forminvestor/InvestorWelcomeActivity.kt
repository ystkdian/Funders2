package com.example.funders.ui.forminvestor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.funders.databinding.ActivityInvestorWelcomeBinding
import com.example.funders.ui.signup.ChooseRoleActivity

class InvestorWelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInvestorWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInvestorWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ChooseRoleActivity::class.java)
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, InvestorFormActivity::class.java)
            startActivity(intent)
        }
    }
}