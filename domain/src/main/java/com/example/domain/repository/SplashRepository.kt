package com.example.domain.repository

import com.example.domain.model.GetFirebaseResponse

interface SplashRepository {
    suspend fun check(): GetFirebaseResponse<String>
}