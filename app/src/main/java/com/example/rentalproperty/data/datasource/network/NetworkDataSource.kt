package com.example.rentalproperty.data.datasource.network

import com.example.rentalproperty.app.UnauthorizedException
import com.example.rentalproperty.data.datasource.network.api.ApiService
import com.example.rentalproperty.data.datasource.network.api.model.AdvertisementDto
import com.example.rentalproperty.data.datasource.network.api.model.UserDto
import com.example.rentalproperty.data.mapper.toAdvertisement
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
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val api: ApiService
) {

    var accessToken: String? = null

    suspend fun validateUser(user: User): UserAuthenticate =
        api.validateUser(TOKEN_PREFIX + user.accessToken).let {
            return when (it.code()) {
                200 -> UserAuthenticate.IsAuthenticate
                else -> UserAuthenticate.NotAuthenticate
            }
        }

    suspend fun registerUser(user: User): UserAuthenticate =
        when(api.registerUser(user.toUserDto()).code()) {
            200 -> UserAuthenticate.SuccessRegister
            else -> UserAuthenticate.NotRegistered
        }

    suspend fun loginUser(user: User): UserDto? =
        api.loginUser(user.toUserDto()).body().also {
            accessToken = it?.token
        }

    suspend fun downloadAdvertisements(): List<AdvertisementDto>? =
        api.getAdvertisements(TOKEN_PREFIX + accessToken).let {
            Timber.e(it.toString())
            return when (it.code()) {
                200 -> it.body()
                else -> throw UnauthorizedException()
            }
        }

    private companion object {
        private const val TOKEN_PREFIX = "Bearer_"
    }
}