package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataLoveResponse
import com.example.domain.utils.RemoteErrorEmitter
interface MainDataSource {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        // API 인자
        host: String,
        key: String,
        // fName = 남자 이름
        mName : String,
        // sName = 여자 이름
        wName : String,
    ) : DataLoveResponse?
}