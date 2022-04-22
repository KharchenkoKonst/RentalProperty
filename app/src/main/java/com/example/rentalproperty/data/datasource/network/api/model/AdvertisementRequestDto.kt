package com.example.rentalproperty.data.datasource.network.api.model

data class AdvertisementRequestDto(
    val region: String,
    val images: List<ByteArray>
)
