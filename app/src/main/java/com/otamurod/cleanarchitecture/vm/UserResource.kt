package com.otamurod.cleanarchitecture.vm

import com.otamurod.domain.models.UserData

sealed class UserResource {
    object Loading : UserResource()
    data class Success(val list: List<UserData>?) : UserResource()
    data class Error(val message: String?) : UserResource()
}
