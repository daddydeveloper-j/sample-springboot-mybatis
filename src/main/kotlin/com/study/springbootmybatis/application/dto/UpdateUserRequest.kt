package com.study.springbootmybatis.application.dto

data class UpdateUserRequest(
    val name: String,
    val email: String,
    val password: String,
    val age: Int
)
