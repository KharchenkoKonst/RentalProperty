package com.example.rentalproperty.di.module

import com.example.rentalproperty.data.repository.UserRepositoryImpl
import com.example.rentalproperty.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {

    @Binds
    fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}