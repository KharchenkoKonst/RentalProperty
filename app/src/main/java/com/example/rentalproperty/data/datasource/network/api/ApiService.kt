package com.example.rentalproperty.data.datasource.network.api

import com.example.rentalproperty.data.datasource.network.api.model.AdvertisementRequestDto
import com.example.rentalproperty.data.datasource.network.api.model.AdvertisementResponseDto
import com.example.rentalproperty.data.datasource.network.api.model.UserDto
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("api/v1/auth/register")
    suspend fun registerUser(
        @Body userDto: UserDto
    ): Response<Void>

    @POST("api/v1/auth/login")
    suspend fun loginUser(
        @Body userDto: UserDto
    ): Response<UserDto>

    @GET("api/v1/advertisements")
    suspend fun getAdvertisements(
        @Header("Authorization") token: String
    ): Response<List<AdvertisementResponseDto>>

    @POST("api/v1/advertisements")
    suspend fun uploadAdvertisement(
        @Header("Authorization") token: String,
        @Body advertisementRequestDto: AdvertisementRequestDto
    ): Response<Void>

    companion object {

        const val BASE_URL = "http://10.0.2.2:8080/"

    }

}