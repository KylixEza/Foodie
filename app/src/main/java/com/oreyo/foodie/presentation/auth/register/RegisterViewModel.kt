package com.oreyo.foodie.presentation.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.oreyo.foodie.data.repository.IFoodieRepository
import com.oreyo.foodie.data.source.remote.api.response.user.UserBody
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: IFoodieRepository) : ViewModel() {

    fun postNewUser(email: String, password: String, body: UserBody) =
        repository.postNewUser(email, password, body).asLiveData()

    fun savePrefEmail(email: String) = viewModelScope.launch {
        repository.savePrefEmail(email)
    }

    fun savePrefHaveRunAppBefore(isFirstTime: Boolean) = viewModelScope.launch {
        repository.savePrefHaveRunAppBefore(isFirstTime)
    }
}