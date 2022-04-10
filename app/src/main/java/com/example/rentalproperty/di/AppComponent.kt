package com.example.rentalproperty.di

import com.example.rentalproperty.di.module.AppModule
import com.example.rentalproperty.domain.interactor.AdvertisementInteractor
import com.example.rentalproperty.domain.interactor.UserInteractor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    val userInteractor: UserInteractor
    val advertisementInteractor: AdvertisementInteractor

}
