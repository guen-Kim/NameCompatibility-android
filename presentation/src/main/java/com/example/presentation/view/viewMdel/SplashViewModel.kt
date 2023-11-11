package com.example.presentation.view.viewMdel

import com.example.domain.usecase.CheckAppVersionUseCase
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val checkAppVersionUseCase: CheckAppVersionUseCase
){
    suspend fun excute() = checkAppVersionUseCase.excute()
}