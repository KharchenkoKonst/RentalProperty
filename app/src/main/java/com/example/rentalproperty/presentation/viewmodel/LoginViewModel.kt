package com.example.rentalproperty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalproperty.domain.interactor.UserInteractor
import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate
import com.example.rentalproperty.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import timber.log.Timber

class LoginViewModel(
    private val userInteractor: UserInteractor
) : ViewModel() {

    val loadAdvertisement = SingleLiveEvent<Unit>()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            when (userInteractor.login(User(username, password))) {
                is UserAuthenticate.IsAuthenticate -> loadAdvertisement.call()
                is UserAuthenticate.NotRegistered -> Timber.e("User not registered")
                else -> Timber.e("Service error")
            }
        }
    }

    fun register(username: String, password: String) {
        viewModelScope.launch {
            when (userInteractor.register(User(username, password))) {
                is UserAuthenticate.IsAuthenticate -> loadAdvertisement.call()
                is UserAuthenticate.NotRegistered -> Timber.e("User was not registered")
                else -> Timber.e("User was not authenticated")
            }
        }
    }

}