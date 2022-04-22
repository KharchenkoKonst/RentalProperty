package com.example.rentalproperty.data.repository

import com.example.rentalproperty.data.datasource.local.LocalDataSource
import com.example.rentalproperty.data.datasource.network.NetworkDataSource
import com.example.rentalproperty.data.mapper.toUser
import com.example.rentalproperty.data.mapper.toUserEntity
import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate
import com.example.rentalproperty.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) : UserRepository {

    override suspend fun getSavedUser(): User? =
        localDataSource.getSavedUser().lastOrNull()?.toUser().also {
            networkDataSource.accessToken = it?.accessToken
        }

    override suspend fun registerUser(user: User): UserAuthenticate =
        networkDataSource.registerUser(user)

    override suspend fun loginUser(user: User): UserAuthenticate =
        networkDataSource.loginUser(user).let { userDto ->
            when (userDto) {
                null -> UserAuthenticate.NotRegistered
                else -> UserAuthenticate.IsAuthenticate.also {
                    localDataSource.updateUserData(
                        userDto.toUserEntity()
                    )
                }
            }
        }

}