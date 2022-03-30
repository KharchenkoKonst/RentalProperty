package com.example.rentalproperty.di.module

import dagger.Module

@Module(includes = [NetworkModule::class, AppBindModule::class])
class AppModule {
}
