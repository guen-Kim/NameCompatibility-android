package com.example.presentation.view

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.utils.ErrorType
import com.example.domain.utils.ScreenState
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentManNameBinding
import com.example.presentation.view.viewMdel.MainViewModel
import com.example.presentation.widget.EventObserver
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {
    private val mainViewModel by activityViewModels<MainViewModel>()


    override fun init() {
        binding.fragment = this
        observeMainViewModel()
    }


    fun resultBtnClick(view: View) {
        binding.lodingBar.visibility = View.VISIBLE
        mainViewModel.manNameResult = binding.etName.text.toString()
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "6f15755a03msh1e9952813104629p1ae459jsn2facf2b12aaa",
            mainViewModel.manNameResult,
            mainViewModel.womanNameResult
        )
    }


    private fun observeMainViewModel() {
        // remote API observe
        binding.lodingBar.visibility = View.INVISIBLE
        mainViewModel.apiCallEvent.observe(this, EventObserver {
            when (it) {
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortShowToast("알수없는 에러발생")

            }
        })


    }

    private fun toastErrorMsg() {
        when (mainViewModel.apiErrorType) {
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다.")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다.")
            ErrorType.TIMEOUT -> longShowToast("호출시간이 초과되었습니다.")
            ErrorType.UNKNOWN -> longShowToast("예기치못한 에러가 발생하였습니다.")


        }
    }

}