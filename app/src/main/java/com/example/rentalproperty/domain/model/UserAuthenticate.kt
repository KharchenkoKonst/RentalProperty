package com.example.rentalproperty.domain.model

sealed class UserAuthenticate {

    object IsAuthenticate : UserAuthenticate()

    object NotAuthenticate : UserAuthenticate()

}