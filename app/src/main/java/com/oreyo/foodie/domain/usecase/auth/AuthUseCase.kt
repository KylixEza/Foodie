package com.oreyo.foodie.domain.usecase.auth

import kotlinx.coroutines.flow.Flow

interface AuthUseCase {
    suspend fun savePrefEmail(email: String)
    suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean)
    fun readPreEmail(): Flow<Boolean>
    fun readPrefHaveRunAppBefore(): Flow<Boolean>
}