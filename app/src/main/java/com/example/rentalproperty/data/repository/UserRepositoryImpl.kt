package com.example.rentalproperty.data.repository

import androidx.lifecycle.LiveData
import com.example.rentalproperty.data.datasource.local.LocalDataSource
import com.example.rentalproperty.data.datasource.network.NetworkDataSource
import com.example.rentalproperty.data.db.dao.UserDao
import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) : UserRepository {

    override fun getUserById(id: Int): LiveData<User> {
        TODO()
    }
}