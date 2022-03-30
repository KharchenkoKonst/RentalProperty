package com.example.rentalproperty.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalproperty.domain.interactor.UserInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val userInteractor: UserInteractor
) : ViewModel() {

    val isAuthenticated = MutableLiveData<Boolean>()

    fun tryAuthenticate() {
        viewModelScope.launch {
            userInteractor.authenticateUser()
        }
    }
}