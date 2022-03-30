package com.example.rentalproperty.data.datasource.local

import com.example.rentalproperty.data.db.dao.UserDao
import com.example.rentalproperty.domain.model.User
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val userDao: UserDao
) {

//    fun getSavedUser() {}

}