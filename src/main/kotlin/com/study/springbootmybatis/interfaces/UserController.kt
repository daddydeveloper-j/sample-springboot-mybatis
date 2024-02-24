package com.study.springbootmybatis.interfaces

import com.study.springbootmybatis.application.dto.RegisterUserRequest
import com.study.springbootmybatis.domain.User
import org.springframework.web.bind.annotation.*

@RestController
class UserController {
    private var userSequence: Long = 0
    private val users: MutableMap<Long, User> = mutableMapOf()

    @GetMapping("/users")
    fun getUsers(): List<User> {
        return users.map { it.value }
    }

    @GetMapping("/users/{seq}")
    fun getUser(@PathVariable seq: Long): User {
        return users[seq] ?: throw RuntimeException("등록된 유저가 없습니다.")
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
