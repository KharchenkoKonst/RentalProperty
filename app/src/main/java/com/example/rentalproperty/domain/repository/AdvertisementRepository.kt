package com.example.rentalproperty.domain.repository

import com.example.rentalproperty.domain.model.Advertisement

interface AdvertisementRepository {

    suspend fun getAdvertisements(): List<Advertisement>
    suspend fun publishAdvertisement(advertisement: Advertisement)
}