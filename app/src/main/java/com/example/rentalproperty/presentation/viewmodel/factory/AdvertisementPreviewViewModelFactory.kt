package com.example.rentalproperty.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentalproperty.domain.interactor.AdvertisementInteractor
import com.example.rentalproperty.presentation.viewmodel.AdvertisementPreviewViewModel

@Suppress("UNCHECKED_CAST")
class AdvertisementPreviewViewModelFactory(
    private val advertisementInteractor: AdvertisementInteractor
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        AdvertisementPreviewViewModel(advertisementInteractor) as T
}