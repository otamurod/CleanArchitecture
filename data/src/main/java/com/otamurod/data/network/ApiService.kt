package com.otamurod.data.network

import com.otamurod.domain.models.UserData
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers():Flow<List<UserData>>
}