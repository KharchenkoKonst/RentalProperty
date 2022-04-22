package com.example.rentalproperty.presentation.model

data class AdvertisementModel(
    val region: String,
    val pricePerMoth: String,
    val address: String,
    val ownerUsername: String,
    val imageUrls: List<String>
)
