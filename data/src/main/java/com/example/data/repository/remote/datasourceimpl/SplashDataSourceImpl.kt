package com.example.data.repository.remote.datasourceimpl

import com.example.data.mapper.FirebaseMapper.toResultString
import com.example.data.repository.remote.datasource.SplashDataSource
import com.example.data.utils.base.BaseDataSource
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class SplashDataSourceImpl(
     private val firebaseRtdb : FirebaseDatabase,
     private val firestore: FirebaseFirestore,

 ): BaseDataSource(), SplashDataSource {
    override suspend fun checkVersion() = safeGetFirebaseRTDBCall{
        firebaseRtdb.reference.child("appVersion").get()
    }.toResultString()
}