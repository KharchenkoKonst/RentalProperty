package com.example.rentalproperty.domain.interactor

import com.example.rentalproperty.domain.model.Advertisement
import com.example.rentalproperty.domain.repository.AdvertisementRepository
import javax.inject.Inject

class AdvertisementInteractor @Inject constructor(
    private val advertisementRepository: AdvertisementRepository
) {

    suspend fun getAdvertisements(): List<Advertisement> =
        advertisementRepository.getAdvertisements()

}