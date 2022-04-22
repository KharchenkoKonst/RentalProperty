package com.example.rentalproperty.data.datasource.network

import com.example.rentalproperty.app.UnauthorizedException
import com.example.rentalproperty.data.datasource.network.api.ApiService
import com.example.rentalproperty.data.datasource.network.api.model.AdvertisementRequestDto
import com.example.rentalproperty.data.datasource.network.api.model.AdvertisementResponseDto
import com.example.rentalproperty.data.datasource.network.api.model.UserDto
import com.example.rentalproperty.data.mapper.toAdvertisementDtoRequest
import com.example.rentalproperty.data.mapper.toUserDto
import com.example.rentalproperty.domain.model.Advertisement
import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val api: ApiService
) {

    var accessToken: String? = null

    suspend fun registerUser(user: User): UserAuthenticate =
        when (api.registerUser(user.toUserDto()).code()) {
            200 -> UserAuthenticate.SuccessRegister
            else -> UserAuthenticate.NotRegistered
        }

    suspend fun loginUser(user: User): UserDto? =
        api.loginUser(user.toUserDto()).body().also {
            accessToken = it?.token
        }

    suspend fun downloadAdvertisements(): List<AdvertisementResponseDto>? =
        api.getAdvertisements(TOKEN_PREFIX + accessToken).let {
            Timber.e(it.toString())
            return when (it.code()) {
                200 -> it.body()
                else -> throw UnauthorizedException()
            }
        }

    suspend fun uploadAdvertisement(advertisement: Advertisement) {
        api.uploadAdvertisement(
            TOKEN_PREFIX + accessToken,
            advertisement.toAdvertisementDtoRequest()
        )
    }

    private companion object {

        private const val TOKEN_PREFIX = "Bearer_"

    }

}