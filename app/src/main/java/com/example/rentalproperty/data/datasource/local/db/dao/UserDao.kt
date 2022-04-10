package com.example.rentalproperty.data.datasource.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rentalproperty.data.datasource.local.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>

    @Query("DELETE FROM user")
    suspend fun deleteAll()

    @Insert
    suspend fun insert(user: UserEntity)

    @Update
    suspend fun update(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)
}