package com.example.domain.model

data class GetFirebaseResponse<T>(
    val state : FirebaseState,
    val result : T?
)

data class SetFirebaseResponse(
    val state : FirebaseState
)

enum class FirebaseState {
    SUCCESS,
    FAILURE
}