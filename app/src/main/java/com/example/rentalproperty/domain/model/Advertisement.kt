package com.example.rentalproperty.domain.model

import java.io.InputStream

data class Advertisement(
    val region: String,
    val imagesStream: List<InputStream>? = null,
    val imagesUrl: List<String>? = null
)
