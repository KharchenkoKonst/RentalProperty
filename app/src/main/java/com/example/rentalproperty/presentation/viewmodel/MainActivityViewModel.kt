package com.example.rentalproperty.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalproperty.domain.interactor.UserInteractor
import com.example.rentalproperty.domain.model.User
import com.example.rentalproperty.domain.model.UserAuthenticate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : ViewModel() {

    val isAuthenticated = MutableLiveData<Boolean>()

    fun tryAuthenticate() {
        viewModelScope.launch(Dispatchers.IO) {
            userInteractor.tryAuthenticate().let {
                when (it) {
                    UserAuthenticate.IsAuthenticate -> {
                        Timber.e("Authorized")
                    }
                    UserAuthenticate.NotAuthenticate -> {
                        /**
                         * Сценарий регистрации
                         */
                        val username = "username"
                        val password = "password"
                        val user = User(username, password)
                        Timber.e(userInteractor.register(user).toString())
                    }
                }
            }
        }
    }
}