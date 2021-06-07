package com.example.funders.ui.investor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.funders.R
import com.example.funders.databinding.FragmentInvestorBinding

class InvestorFragment : Fragment() {

    private lateinit var investorViewModel: InvestorViewModel
    private lateinit var fragmentInvestorBinding: FragmentInvestorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentInvestorBinding = FragmentInvestorBinding.inflate(layoutInflater, container, false)
        return fragmentInvestorBinding.root
    }
}