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
    fun getUsers(): List<User> = userMapper.findAll()

    fun getUser(seq: Long): User = userMapper.findBySeq(seq) ?: throw RuntimeException("등록된 유저가 없습니다.")

    fun registerUser(req: RegisterUserRequest): Long {
        val user = User(
            name = req.name,
            email = req.email,
            password = req.password,
            age = req.age
        )

        return userMapper.saveUser(user)
    }

    fun updateUser(seq: Long, req: UpdateUserRequest) {
        val updatedUser = User(
            seq = seq,
            name = req.name,
            email = req.email,
            password = req.password,
            age = req.age
        )

        val updatedResult = userMapper.updateUser(updatedUser)
        if (updatedResult == 0) {
            throw RuntimeException("유저 변경에 실패 했습니다.")
        }
    }
}
