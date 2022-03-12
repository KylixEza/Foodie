package com.oreyo.foodie.domain.repository

import kotlinx.coroutines.flow.Flow

interface IFoodieRepository {

    suspend fun savePrefEmail(email: String)
    suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean)
    fun readPreEmail(): Flow<Boolean>
    fun readPrefHaveRunAppBefore(): Flow<Boolean>
}