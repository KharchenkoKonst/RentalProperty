package com.example.rentalproperty.di.module

import android.content.Context
import androidx.room.Room
import com.example.rentalproperty.data.datasource.local.db.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class StorageModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "database"
    ).build()

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase) = database.userDao()

}