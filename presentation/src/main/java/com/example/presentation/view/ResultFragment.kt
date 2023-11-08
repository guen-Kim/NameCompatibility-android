package com.example.presentation.view

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentResultBinding
import com.example.presentation.view.viewMdel.MainViewModel


class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val mainViewModel by activityViewModels<MainViewModel> ()

    override fun init() {
        binding.fragment = this
        initReulst()
    }
    private fun initReulst(){
        when(mainViewModel.apiCallResult.percentage){
            in 0..20 -> setLoveMsgTxt("그래요.")
            in 21..40 -> setLoveMsgTxt("조금 그래요.")
            in 41..70 -> setLoveMsgTxt("나쁘지 않아요. ")
            in 71..90 -> setLoveMsgTxt("좋아요!")
            in 91..99 -> setLoveMsgTxt("아주 좋아요!!")
            100 -> {
                setLoveMsgTxt("완벽하네요.")
            } else -> setLoveMsgTxt("알수없는 힘?!")
        }
        binding.tvScore.text = mainViewModel.apiCallResult.percentage.toString()
        Log.d("okhhtp_f", mainViewModel.toString())
    }

    private fun setLoveMsgTxt(msg: String) {
        binding.tvMsg.text = msg
    }



    fun nextBtnClick(view: View) {
        findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}