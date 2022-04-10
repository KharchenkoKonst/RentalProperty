package com.example.rentalproperty.domain.interactor

import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate
import com.example.rentalproperty.domain.repository.UserRepository
import timber.log.Timber
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun validateAccessToken(): UserAuthenticate =
        userRepository.getSavedUser().let {
            when (it) {
                null -> UserAuthenticate.NotAuthenticate
                else -> UserAuthenticate.IsAuthenticate
            }
        }

    suspend fun login(user: User): UserAuthenticate =
        userRepository.loginUser(user)

    suspend fun register(user: User): UserAuthenticate =
        userRepository.registerUser(user).let {
            return when (it) {
                is UserAuthenticate.SuccessRegister -> userRepository.loginUser(user)
                else -> UserAuthenticate.NotRegistered
            }
        }

}