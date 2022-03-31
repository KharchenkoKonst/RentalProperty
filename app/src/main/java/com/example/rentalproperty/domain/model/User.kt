package com.example.rentalproperty.domain.model

data class User(
    val username: String,
    val password: String? = null,
    val accessToken: String? = null
)

