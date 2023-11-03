package com.example.presentation.view

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentResultBinding

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    override fun init() {
        binding.fragment = this

    }


    fun nextBtnClick(view: View) {
        findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}