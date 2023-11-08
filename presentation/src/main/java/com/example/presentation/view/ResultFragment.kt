package com.example.presentation.view

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentResultBinding
import com.example.presentation.view.viewMdel.MainViewModel



class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val mainViewModel by viewModels<MainViewModel> ()

    override fun init() {
        binding.fragment = this

    }
    private fun initReulst(){
        binding.tvScore.text = mainViewModel.apiCallResult.result.toString()
        when(mainViewModel.apiCallResult.percentage){
            in 0..20 -> setLoveMsgTxt(" ")
            in 21..40 -> setLoveMsgTxt(" ")
            in 41..70 -> setLoveMsgTxt(" ")
            in 71..90 -> setLoveMsgTxt(" ")
            in 91..99 -> setLoveMsgTxt(" ")
            100 -> {
                setLoveMsgTxt("완벽하네요.")
            } else -> setLoveMsgTxt("알수없는 힘?!")


        }
    }

    private fun setLoveMsgTxt(msg: String) {
        binding.tvMsg.text = msg
    }



    fun nextBtnClick(view: View) {
        findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}