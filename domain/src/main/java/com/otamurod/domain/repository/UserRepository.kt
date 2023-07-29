package com.otamurod.domain.repository

import com.otamurod.domain.models.UserData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<UserData>>
}