package com.oreyo.foodie.data.repository

import com.oreyo.foodie.data.mechanism.NetworkBoundRequest
import com.oreyo.foodie.data.mechanism.NetworkOnlyResource
import com.oreyo.foodie.data.source.local.LocalDataSource
import com.oreyo.foodie.data.source.remote.RemoteDataSource
import com.oreyo.foodie.data.source.remote.api.response.user.UserBody
import com.oreyo.foodie.data.source.remote.api.response.user.UserResponse
import com.oreyo.foodie.data.source.remote.api.service.ApiResponse
import com.oreyo.foodie.data.util.Resource
import com.oreyo.foodie.util.toUserEntity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FoodieRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): IFoodieRepository {

    override fun postNewUser(email: String, password: String, body: UserBody): Flow<Resource<Unit>> =
        object : NetworkBoundRequest<UserResponse>() {
            override suspend fun createCall(): Flow<ApiResponse<UserResponse>> {
                return remoteDataSource.postNewUser(email, password, body)
            }
            override suspend fun saveCallResult(data: UserResponse) {
                localDataSource.insertUser(data.toUserEntity())
            }
        }.asFlow()

    override fun signInUser(email: String, password: String): Flow<Resource<Unit>> =
        object : NetworkBoundRequest<UserResponse>() {
            override suspend fun createCall(): Flow<ApiResponse<UserResponse>> {
                return remoteDataSource.signInUser(email, password)
            }

            override suspend fun saveCallResult(data: UserResponse) {
                localDataSource.insertUser(data.toUserEntity())
            }
        }.asFlow()

    override suspend fun savePrefEmail(email: String) {
        localDataSource.savePrefEmail(email)
    }

    override suspend fun savePrefHaveRunAppBefore(isFirstTime: Boolean) {
        localDataSource.savePrefHaveRunAppBefore(isFirstTime)
    }

    override fun readPreEmail(): Flow<Boolean> = localDataSource.readPreEmail()

    override fun readPrefHaveRunAppBefore(): Flow<Boolean> = localDataSource.readPrefHaveRunAppBefore()


}