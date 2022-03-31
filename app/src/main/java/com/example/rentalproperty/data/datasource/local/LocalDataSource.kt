package com.example.rentalproperty.data.datasource.local

import com.example.rentalproperty.data.datasource.local.db.dao.UserDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun getSavedUser() =
        userDao.getAll()

}