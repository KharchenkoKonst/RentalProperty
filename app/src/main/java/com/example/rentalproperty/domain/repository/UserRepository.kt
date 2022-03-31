package com.example.rentalproperty.domain.repository

import com.example.rentalproperty.data.datasource.network.api.model.UserDto
import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate

interface UserRepository {

    suspend fun getSavedUser(): User?
    suspend fun validateUser(user: User): UserAuthenticate
    suspend fun registerUser(user: User): Int
    suspend fun loginUser(user: User): UserDto?

}