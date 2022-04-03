package com.oreyo.foodie.data.mechanism

import com.oreyo.foodie.data.util.FirebaseResponse
import com.oreyo.foodie.data.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.first

abstract class NetworkBoundRequest<RequestType> {
    private val result: Flow<Resource<Unit>> = flow {
        preRequest()
        emit(Resource.Loading())
        when (val firebaseResponse = createCall().first()) {
            is FirebaseResponse.Success<RequestType> -> {
                saveCallResult(firebaseResponse.data)
                emit(Resource.Success(null))
            }
            is FirebaseResponse.Error -> {
                emit(
                    Resource.Error<Unit>(
                        firebaseResponse.errorMessage
                    )
                )
            }
        }
    } as Flow<Resource<Unit>>

    protected open suspend fun preRequest(){}

    protected abstract suspend fun createCall(): Flow<FirebaseResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow() = result
}