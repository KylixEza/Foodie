package com.oreyo.foodie.data.source.remote

import com.oreyo.foodie.data.source.remote.api.response.GeneralListResponse
import com.oreyo.foodie.data.source.remote.api.service.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

suspend inline fun<T> generalListCallHelper(crossinline block: suspend () -> GeneralListResponse<T>) = flow {
    try {
        val data = block().data
        val count = block().count
        if (count == 0) {
            emit(ApiResponse.Empty())
        } else {
            emit(ApiResponse.Success(data))
        }
    } catch (e: Exception) {
        emit(ApiResponse.Error(e.message.toString()))
    }
}.flowOn(Dispatchers.IO)