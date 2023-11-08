package com.example.presentation.view

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentWomanBinding
import com.example.presentation.view.viewMdel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WomanNameFragment : BaseFragment<FragmentWomanBinding>(R.layout.fragment_woman) {

   private val mainViewModel by activityViewModels<MainViewModel> ()


    override fun init() {
        Log.d("asdfasdfasdf", mainViewModel.toString())
        binding.fragment = this
    }




    fun nextBtnClick(view: View) {
        //여자 이름을 저장 후 다음 화면으로 넘어간다.
        mainViewModel.womanNameResult = binding.etName.text.toString()

        this.findNavController().navigate(R.id.action_womanNameFragment_to_manNameFragment)
    }
}