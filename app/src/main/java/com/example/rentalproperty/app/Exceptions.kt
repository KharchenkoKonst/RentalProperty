package com.example.rentalproperty.app

import java.lang.Exception

class UnauthorizedException(message: String = "User is not authorized") : Exception(message)