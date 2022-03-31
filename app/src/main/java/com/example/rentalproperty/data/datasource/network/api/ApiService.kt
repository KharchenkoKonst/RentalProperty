package com.example.rentalproperty.data.datasource.network.api

import com.example.rentalproperty.data.datasource.network.api.model.UserDto
import com.example.rentalproperty.data.datasource.network.api.model.ValidationDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @GET("api/v1/auth/validate")
    suspend fun validateUser(
        @Header("Authorization") token: String
    ): Response<ValidationDto>

    @POST("api/v1/auth/register")
    suspend fun registerUser(
        @Body userDto: UserDto
    ): Response<Void>

    @POST("api/v1/auth/login")
    suspend fun loginUser(
        @Body userDto: UserDto
    ): Response<UserDto>

    companion object {

        const val BASE_URL = "http://10.0.2.2:8080/"

    }

}