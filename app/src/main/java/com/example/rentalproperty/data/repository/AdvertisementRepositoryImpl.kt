package com.example.rentalproperty.data.repository

import com.example.rentalproperty.app.UnauthorizedException
import com.example.rentalproperty.data.datasource.local.LocalDataSource
import com.example.rentalproperty.data.datasource.network.NetworkDataSource
import com.example.rentalproperty.data.mapper.toAdvertisement
import com.example.rentalproperty.domain.model.Advertisement
import com.example.rentalproperty.domain.repository.AdvertisementRepository
import javax.inject.Inject

class AdvertisementRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) : AdvertisementRepository {

    override suspend fun getAdvertisements(): List<Advertisement> =
        networkDataSource.downloadAdvertisements()?.map { it.toAdvertisement() }.orEmpty()
}