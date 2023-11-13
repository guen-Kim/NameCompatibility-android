package com.example.data.repository

import com.example.data.repository.remote.datasource.SplashDataSource
import com.example.domain.model.GetFirebaseResponse
import com.example.domain.repository.SplashRepository
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(val splashDataSource: SplashDataSource) : SplashRepository {
    override suspend fun checkAppVersion(): GetFirebaseResponse<String> {
        return splashDataSource.checkVersion();
    }
}