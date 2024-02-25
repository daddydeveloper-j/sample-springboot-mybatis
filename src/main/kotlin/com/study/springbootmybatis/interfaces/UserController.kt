package com.study.springbootmybatis.interfaces

import com.study.springbootmybatis.application.UserService
import com.study.springbootmybatis.application.dto.RegisterUserRequest
import com.study.springbootmybatis.application.dto.UpdateUserRequest
import com.study.springbootmybatis.domain.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/users")
    fun getUsers(): List<User> = userService.getUsers()

    @GetMapping("/users/{seq}")
    fun getUser(@PathVariable seq: Long): User = userService.getUser(seq)

    @PostMapping("/users")
    fun registerUser(@RequestBody req: RegisterUserRequest): Long = userService.registerUser(req)

    @PutMapping("/users/{seq}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun updateUser(@PathVariable seq: Long, @RequestBody req: UpdateUserRequest) =
        userService.updateUser(seq, req)
}
