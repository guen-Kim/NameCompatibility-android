package com.example.data.repository.remote.datasource

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface SplashDataSource {

    suspend fun checkVersion(): Task<DataSnapshot>
}