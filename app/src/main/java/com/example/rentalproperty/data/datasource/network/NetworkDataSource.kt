package com.example.rentalproperty.data.datasource.network

import com.example.rentalproperty.data.datasource.network.api.ApiService
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: ApiService
) {
}