package com.example.rentalproperty.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalproperty.domain.interactor.AdvertisementInteractor
import com.example.rentalproperty.domain.model.Advertisement
import kotlinx.coroutines.launch

class AdvertisementCreateViewModel(
    private val advertisementInteractor: AdvertisementInteractor
) : ViewModel() {

    fun publishAdvertisement(advertisement: Advertisement){
        viewModelScope.launch {
            advertisementInteractor.publishAdvertisement(advertisement)
        }
    }

}