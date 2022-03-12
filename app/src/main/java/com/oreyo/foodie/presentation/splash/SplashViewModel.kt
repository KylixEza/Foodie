package com.oreyo.foodie.presentation.splash

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.oreyo.foodie.domain.usecase.auth.AuthUseCase
import kotlinx.coroutines.Dispatchers

class SplashViewModel(
    private val authUseCase: AuthUseCase
): ViewModel() {

    fun readPrefEmail() = authUseCase.readPreEmail().asLiveData(Dispatchers.IO)
    fun readPrefHaveRunAppBefore() = authUseCase.readPrefHaveRunAppBefore().asLiveData(Dispatchers.IO)
}