package com.study.springbootmybatis.infrastructure

import com.study.springbootmybatis.domain.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun findAll(): List<User>
}
