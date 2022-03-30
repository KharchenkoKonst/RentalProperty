package com.example.rentalproperty.di.module

import com.example.rentalproperty.data.datasource.network.api.ApiService
import com.example.rentalproperty.data.datasource.network.api.ApiService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideDataApi(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create()
    }

}