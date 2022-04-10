package com.example.rentalproperty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalproperty.domain.interactor.UserInteractor
import com.example.rentalproperty.domain.model.UserAuthenticate
import com.example.rentalproperty.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class StarterViewModel(
    private val userInteractor: UserInteractor
) : ViewModel() {

    val loadAdvertisements = SingleLiveEvent<Unit>()
    val requireLogin = SingleLiveEvent<Unit>()

    init {
        viewModelScope.launch {
            userInteractor.validateAccessToken().let {
                when (it) {
                    is UserAuthenticate.IsAuthenticate -> loadAdvertisements.call()
                    is UserAuthenticate.NotAuthenticate -> requireLogin.call()
                }
            }
        }
    }
}