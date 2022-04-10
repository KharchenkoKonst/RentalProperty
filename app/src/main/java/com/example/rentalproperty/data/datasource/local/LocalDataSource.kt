package com.example.rentalproperty.data.datasource.local

import com.example.rentalproperty.data.datasource.local.db.dao.UserDao
import com.example.rentalproperty.data.datasource.local.db.entity.UserEntity
import com.example.rentalproperty.domain.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun getSavedUser() =
        userDao.getAll()

    suspend fun updateUserData(user: UserEntity) {
        with(userDao) {
            deleteAll()
            insert(user)
        }
    }
}