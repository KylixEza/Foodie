package com.oreyo.foodie.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.oreyo.foodie.data.repository.IFoodieRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: IFoodieRepository) : ViewModel() {

    fun savePrefEmail(email: String) = viewModelScope.launch {
        repository.savePrefEmail(email)
    }

    fun savePrefHaveRunAppBefore(isFirstTime: Boolean) = viewModelScope.launch {
        repository.savePrefHaveRunAppBefore(isFirstTime)
    }

    fun signIn(email: String, password: String) =
        repository.signInUser(email, password).asLiveData()
}