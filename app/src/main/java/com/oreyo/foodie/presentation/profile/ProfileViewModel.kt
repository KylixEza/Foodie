package com.oreyo.foodie.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oreyo.foodie.data.repository.IFoodieRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: IFoodieRepository) : ViewModel() {

    fun savePrefEmail() = viewModelScope.launch {
        repository.savePrefEmail("null")
    }
}