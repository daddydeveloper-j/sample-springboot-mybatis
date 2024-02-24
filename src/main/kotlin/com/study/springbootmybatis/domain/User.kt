package com.study.springbootmybatis.domain

data class User(
    val seq: Long,
    val name: String,
    val email: String,
    val password: String,
    val age: Int
)
