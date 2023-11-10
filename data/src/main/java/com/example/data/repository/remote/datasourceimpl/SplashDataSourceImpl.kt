package com.example.data.repository.remote.datasourceimpl

import com.example.data.repository.remote.datasource.SplashDataSource
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class SplashDataSourceImpl(
     private val firebaseRtdb : FirebaseDatabase,
     private val firestore: FirebaseFirestore,

 ): SplashDataSource {
    override suspend fun checkVersion(): Task<DataSnapshot> {
       return firebaseRtdb.reference.child("version").get()
    }

}