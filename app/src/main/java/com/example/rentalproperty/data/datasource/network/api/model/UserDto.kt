package com.example.rentalproperty.data.datasource.network.api.model

data class UserDto(
    val username: String,
    val password: String?,
    val token: String?
)