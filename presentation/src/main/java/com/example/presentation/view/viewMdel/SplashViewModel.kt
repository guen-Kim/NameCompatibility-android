package com.example.presentation.view.viewMdel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.CheckAppVersionUseCase
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val checkAppVersionUseCase: CheckAppVersionUseCase
): ViewModel(){
    fun checkAppVersion() = checkAppVersionUseCase.excute()
}