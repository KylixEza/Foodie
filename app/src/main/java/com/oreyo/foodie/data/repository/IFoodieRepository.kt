package com.oreyo.foodie.data.repository

import com.oreyo.foodie.data.source.remote.api.response.user.UserBody
import com.oreyo.foodie.data.source.remote.api.response.user.UserResponse
import com.oreyo.foodie.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface IFoodieRepository {
    fun postNewUser(email: String, password: String, body: UserBody): Flow<Resource<Unit>>
    fun signInUser(email: String, password: String): Flow<Resource<Unit>>
    suspend fun savePrefEmail(email: String)
    suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean)
    fun readPreEmail(): Flow<Boolean>
    fun readPrefHaveRunAppBefore(): Flow<Boolean>
}