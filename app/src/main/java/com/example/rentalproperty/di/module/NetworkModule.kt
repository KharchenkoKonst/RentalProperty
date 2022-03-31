package com.example.rentalproperty.di.module

import com.example.rentalproperty.data.datasource.network.api.ApiService
import com.example.rentalproperty.data.datasource.network.api.ApiService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideDataApi(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }

}