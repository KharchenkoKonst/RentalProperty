package com.example.rentalproperty.domain.repository

import androidx.lifecycle.LiveData
import com.example.rentalproperty.domain.model.User

interface UserRepository {

    fun getUserById(id: Int): LiveData<User>
}