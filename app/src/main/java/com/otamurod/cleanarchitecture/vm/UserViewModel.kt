package com.otamurod.cleanarchitecture.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otamurod.domain.interactor.UserInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userInteractor: UserInteractor) : ViewModel() {
    fun getUsersFlow(): StateFlow<UserResource> {
        val flow = MutableStateFlow<UserResource>(UserResource.Loading)
        viewModelScope.launch {
            userInteractor.getUsers()
                .catch {
                    flow.emit(UserResource.Error(it.message))
                }
                .collectLatest {
                    if (it.isSuccess) {
                        flow.emit(UserResource.Success(it.getOrNull()))
                    } else if (it.isFailure) {
                        flow.emit(UserResource.Error(it.exceptionOrNull()?.message))
                    }
                }
        }
        return flow
    }
}