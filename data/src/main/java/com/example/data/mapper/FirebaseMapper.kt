package com.example.data.mapper

import com.example.domain.model.GetFirebaseResponse
import com.google.firebase.database.DataSnapshot


object FirebaseMapper {
    fun GetFirebaseResponse<DataSnapshot>.toResultString(): GetFirebaseResponse<String> {
        return GetFirebaseResponse(
            result = this.result?.value.toString(),
            state = this.state
        )
    }
}
