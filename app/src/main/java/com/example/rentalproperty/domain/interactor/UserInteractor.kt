package com.example.rentalproperty.domain.interactor

import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate
import com.example.rentalproperty.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun tryAuthenticate(): UserAuthenticate =
        userRepository.getSavedUser().let {
            when (it) {
                null -> UserAuthenticate.NotAuthenticate
                else -> userRepository.validateUser(it)
            }
        }

    suspend fun register(user: User) =
        userRepository.registerUser(user).let {
            when (it) {
                200 -> userRepository.loginUser(user)
                else -> TODO()
            }
        }
}