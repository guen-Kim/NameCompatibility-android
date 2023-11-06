package com.example.domain.model
//:data response 의존성 없애기 위한 모델 객체
data class DomainLoveResponse(
    val fname: String,
    val sname: String,
    val percentage: String,
    val result: String,
)