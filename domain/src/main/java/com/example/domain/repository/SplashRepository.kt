package com.example.domain.repository

import com.example.domain.model.GetFirebaseResponse

interface SplashRepository {
    fun checkAppVersion(): GetFirebaseResponse<String>
}