package com.otamurod.data.repository

import com.otamurod.domain.models.UserData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<UserData>>
}