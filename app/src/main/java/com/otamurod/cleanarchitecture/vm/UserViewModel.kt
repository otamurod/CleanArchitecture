package com.otamurod.cleanarchitecture.vm

import androidx.lifecycle.ViewModel
import com.otamurod.domain.interactor.UserInteractor
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userInteractor: UserInteractor) : ViewModel() {

}