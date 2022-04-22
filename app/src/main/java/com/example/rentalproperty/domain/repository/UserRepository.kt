package com.example.rentalproperty.domain.repository

import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate

interface UserRepository {

    suspend fun getSavedUser(): User?
    suspend fun registerUser(user: User): UserAuthenticate
    suspend fun loginUser(user: User): UserAuthenticate

}