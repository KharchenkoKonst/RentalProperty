package com.example.rentalproperty.di.module

import com.example.rentalproperty.data.repository.UserRepositoryImpl
import com.example.rentalproperty.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, StorageModule::class, DataBindsModule::class])
class DataModule {
}

@Module
interface DataBindsModule {

    @Binds
    @Singleton
    fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

}
