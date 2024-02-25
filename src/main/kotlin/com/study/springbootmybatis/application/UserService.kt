package com.study.springbootmybatis.application

import com.study.springbootmybatis.application.dto.RegisterUserRequest
import com.study.springbootmybatis.application.dto.UpdateUserRequest
import com.study.springbootmybatis.domain.User
import com.study.springbootmybatis.infrastructure.UserMapper
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userMapper: UserMapper
) {
    private var userSequence: Long = 0
    private val users: MutableMap<Long, User> = mutableMapOf()

    fun getUsers(): List<User> = userMapper.findAll()


    fun getUser(seq: Long): User {
        return users[seq] ?: throw RuntimeException("등록된 유저가 없습니다.")
    }

    fun registerUser(req: RegisterUserRequest): User {
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

    fun updateUser(seq: Long, req: UpdateUserRequest): User {
        val user = users[seq] ?: throw RuntimeException("등록된 유저가 없습니다.")
        val updatedUser = user.copy(
            name = req.name,
            email = req.email,
            password = req.password,
            age = req.age
        )
        users[seq] = updatedUser
        return updatedUser
    }
}
