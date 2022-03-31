package com.example.rentalproperty.data.mapper

import com.example.rentalproperty.data.datasource.local.db.entity.UserEntity
import com.example.rentalproperty.data.datasource.network.api.model.UserDto
import com.example.rentalproperty.domain.model.User

fun UserEntity.toUser() = User(
    username = this.username,
    accessToken = this.accessToken
)

fun User.toUserDto() = UserDto(
    username = this.username,
    password = this.password,
    token =  this.accessToken
)
