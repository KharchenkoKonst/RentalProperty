package com.example.rentalproperty.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalproperty.app.UnauthorizedException
import com.example.rentalproperty.domain.interactor.AdvertisementInteractor
import com.example.rentalproperty.domain.model.Advertisement
import com.example.rentalproperty.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class AdvertisementPreviewViewModel(
    private val advertisementInteractor: AdvertisementInteractor
) : ViewModel() {

    val advertisements = MutableLiveData<List<Advertisement>>()
    val requireAuthorization = SingleLiveEvent<Unit>()

    init {
        print("")
    }

    fun loadAdvertisements() {
        viewModelScope.launch {
            try {
                advertisements.postValue(advertisementInteractor.getAdvertisements())
            } catch (e: Exception) {
                when (e) {
                    is UnauthorizedException -> requireAuthorization.call()
                }
            }
        }
    }

}