package com.oreyo.foodie.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.oreyo.foodie.data.repository.IFoodieRepository
import kotlinx.coroutines.Dispatchers

class SplashViewModel(
    private val repository: IFoodieRepository
): ViewModel() {

    fun readPrefEmail() = repository.readPreEmail().asLiveData(Dispatchers.IO)
    fun readPrefHaveRunAppBefore() = repository.readPrefHaveRunAppBefore().asLiveData(Dispatchers.IO)
}