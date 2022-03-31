package com.example.rentalproperty.data.repository

import androidx.lifecycle.LiveData
import com.example.rentalproperty.data.datasource.local.LocalDataSource
import com.example.rentalproperty.data.datasource.network.NetworkDataSource
import com.example.rentalproperty.data.datasource.network.api.model.UserDto
import com.example.rentalproperty.data.mapper.toUser
import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate
import com.example.rentalproperty.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) : UserRepository {

    override suspend fun getSavedUser(): User? =
        localDataSource.getSavedUser().lastOrNull()?.toUser()

    override suspend fun validateUser(user: User): UserAuthenticate =
        networkDataSource.validateUser(user)

    override suspend fun registerUser(user: User): Int =
        networkDataSource.registerUser(user)

    override suspend fun loginUser(user: User): UserDto? =
        networkDataSource.loginUser(user)



}