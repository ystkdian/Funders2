package com.example.funders.ui.umkm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.funders.R
import com.example.funders.databinding.FragmentUmkmBinding

class UmkmFragment : Fragment() {

    private lateinit var umkmViewModel: UmkmViewModel
    private lateinit var fragmentUmkmBinding: FragmentUmkmBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentUmkmBinding = FragmentUmkmBinding.inflate(layoutInflater, container, false)
        return fragmentUmkmBinding.root
    }
}