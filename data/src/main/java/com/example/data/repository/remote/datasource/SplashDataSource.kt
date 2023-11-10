package com.example.data.repository.remote.datasource

import com.example.domain.model.GetFirebaseResponse


interface SplashDataSource {

    suspend fun checkVersion(): GetFirebaseResponse<String>
}