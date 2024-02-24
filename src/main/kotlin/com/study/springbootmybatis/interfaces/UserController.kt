package com.study.springbootmybatis.interfaces

import com.study.springbootmybatis.application.dto.RegisterUserRequest
import com.study.springbootmybatis.domain.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    private var userSequence: Long = 0
    private val users: MutableMap<Long, User> = mutableMapOf()

    @GetMapping("/users")
    fun getUsers(): List<User> {
        return users.map { it.value }
    }

    @PostMapping("/users")
    fun registerUser(@RequestBody req: RegisterUserRequest): User {
        val user = User(
            seq = ++userSequence,
            name = req.name,
            email = req.email,
            password = req.password,
            age = req.age
        )

        users[user.seq] = user

        return user
    }
}
