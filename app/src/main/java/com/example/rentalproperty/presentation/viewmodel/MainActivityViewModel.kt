package com.example.rentalproperty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rentalproperty.domain.interactor.AdvertisementInteractor
import com.example.rentalproperty.domain.interactor.UserInteractor

class MainActivityViewModel(
    private val userInteractor: UserInteractor,
    private val advertisementInteractor: AdvertisementInteractor
) : ViewModel() {

/*

    fun loadAdvertisements() {
        viewModelScope.launch(Dispatchers.IO) {
//            advertisementInteractor.getAdvertisements()
            delay(2000)
            isAuthenticated.postValue(false)
        }
    }

    fun tryAuthenticate() {
        viewModelScope.launch(Dispatchers.IO) {
            userInteractor.tryAuthenticate().let {
                when (it) {
                    UserAuthenticate.IsAuthenticate -> {
                        Timber.e("Authorized")
                    }
                    UserAuthenticate.NotAuthenticate -> {
                        isAuthenticated.postValue(false)
*/
/*
                        *//*

*/
    /**
     * Сценарий регистрации
     *//*
*/
/*

                        val username = "username"
                        val password = "password"
                        val user = User(username, password)
                        Timber.e(userInteractor.register(user).toString())
*//*

                    }
                }
            }
        }
    }
*/
}