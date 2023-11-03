package com.example.presentation.view

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentWomanBinding

class WomanNameFragment : BaseFragment<FragmentWomanBinding>(R.layout.fragment_woman) {
    override fun init() {
        binding.fragment = this
    }




    fun nextBtnClick(view: View) {
        this.findNavController().navigate(R.id.action_womanNameFragment_to_resultFragment)
    }
}