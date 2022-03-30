package com.example.rentalproperty.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rentalproperty.data.db.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getById(id: Int): LiveData<UserEntity>

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<UserEntity>>

    @Insert
    suspend fun insert(user: UserEntity)

    @Update
    suspend fun update(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)
}