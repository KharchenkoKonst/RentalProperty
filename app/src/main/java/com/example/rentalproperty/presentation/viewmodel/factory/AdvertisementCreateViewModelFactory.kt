package com.example.rentalproperty.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentalproperty.domain.interactor.AdvertisementInteractor
import com.example.rentalproperty.presentation.viewmodel.AdvertisementCreateViewModel

@Suppress("UNCHECKED_CAST")
class AdvertisementCreateViewModelFactory(
    private val advertisementInteractor: AdvertisementInteractor
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        AdvertisementCreateViewModel(advertisementInteractor) as T
}