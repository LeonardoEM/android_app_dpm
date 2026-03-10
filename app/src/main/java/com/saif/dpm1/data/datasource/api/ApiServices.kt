package com.saif.dpm1.data.datasource.api

import com.saif.dpm1.data.response.UserResponse
import retrofit2.http.GET

interface ApiServices {
    @GET("doLogin/.json")
    suspend fun doLogin(): List<UserResponse>//funcion suspendida pq es una corutina
}