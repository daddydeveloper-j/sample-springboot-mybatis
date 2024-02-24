package com.study.springbootmybatis.interfaces

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/users")
    fun getUsers(): List<String> {
        return listOf("test-user-1", "test-user2")
    }
}
