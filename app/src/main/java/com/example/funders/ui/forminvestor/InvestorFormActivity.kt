package com.example.funders.ui.forminvestor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.funders.R
import com.example.funders.databinding.ActivityInvestorFormBinding
import com.example.funders.ui.signup.FinishSignupActivity

class InvestorFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInvestorFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInvestorFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val province = resources.getStringArray(R.array.location)
        val provinceAdapter = ArrayAdapter(this, R.layout.dropdown_layout, province)
        binding.province.setAdapter(provinceAdapter)

        binding.btnFinish.setOnClickListener {
            val intent = Intent(this, FinishSignupActivity::class.java)
            startActivity(intent)
        }
    }
}