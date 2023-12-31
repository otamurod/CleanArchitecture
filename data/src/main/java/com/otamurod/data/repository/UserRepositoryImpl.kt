package com.otamurod.data.repository

import com.otamurod.data.network.ApiService
import com.otamurod.domain.models.UserData
import com.otamurod.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService) : UserRepository {
    override fun getUsers(): Flow<List<UserData>> {
        return apiService.getUsers()
    }
}