package com.oreyo.foodie.data.mechanism

import com.oreyo.foodie.data.source.remote.api.service.ApiResponse
import com.oreyo.foodie.data.util.FirebaseResponse
import com.oreyo.foodie.data.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.first

abstract class NetworkBoundRequest<RequestType> {
    private val result: Flow<Resource<Unit>> = flow {
        preRequest()
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success<RequestType> -> {
                saveCallResult(apiResponse.data)
                emit(Resource.Success(null))
            }
            is ApiResponse.Error -> {
                emit(
                    Resource.Error<Unit>(
                        apiResponse.errorMessage
                    )
                )
            }
        }
    } as Flow<Resource<Unit>>

    protected open suspend fun preRequest(){}

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow() = result
}