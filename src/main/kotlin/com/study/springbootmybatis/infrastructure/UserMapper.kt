package com.study.springbootmybatis.infrastructure

import com.study.springbootmybatis.domain.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {
    @Select("SELECT * FROM ACCOUNTS")
    fun findAll(): List<User>
}
