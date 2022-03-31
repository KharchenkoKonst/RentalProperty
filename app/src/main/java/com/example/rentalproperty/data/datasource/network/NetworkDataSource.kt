package com.example.rentalproperty.data.datasource.network

import com.example.rentalproperty.data.datasource.network.api.ApiService
import com.example.rentalproperty.data.datasource.network.api.model.UserDto
import com.example.rentalproperty.data.mapper.toUserDto
import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: ApiService
) {

    suspend fun validateUser(user: User): UserAuthenticate =
        api.validateUser("Bearer_" + "asd" + user.accessToken).let {
            return when (it.code()) {
                200 -> UserAuthenticate.IsAuthenticate
                else -> UserAuthenticate.NotAuthenticate
            }
        }

    suspend fun registerUser(user: User): Int =
        api.registerUser(user.toUserDto()).code()

    suspend fun loginUser(user: User): UserDto? =
        api.loginUser(user.toUserDto()).body()
}
