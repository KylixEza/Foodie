package com.oreyo.foodie.data.source.remote

import com.oreyo.foodie.data.source.remote.api.response.user.UserBody
import com.oreyo.foodie.data.source.remote.api.response.user.UserResponse
import com.oreyo.foodie.data.source.remote.api.service.ApiResponse
import com.oreyo.foodie.data.source.remote.api.service.ApiService
import com.oreyo.foodie.data.source.remote.firebase.FirebaseResponse
import com.oreyo.foodie.data.source.remote.firebase.FirebaseService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class RemoteDataSource(
    private val apiService: ApiService,
    private val firebaseService: FirebaseService
) {

    suspend fun postNewUser(email: String, password: String, body: UserBody): Flow<ApiResponse<UserResponse>> = flow {
        firebaseService.createUserWithEmailAndPassword(email, password).collect { response ->
            when(response) {
                is FirebaseResponse.Success -> {
                    body.uid = response.data
                    try {
                        apiService.postNewUser(body).data
                        val user = apiService.getDetailUser(response.data).data
                        emit(ApiResponse.Success(user))
                    } catch (e: Exception) {
                        emit(ApiResponse.Error(e.message.toString()))
                    }
                }
                is FirebaseResponse.Error -> emit(ApiResponse.Error(response.errorMessage))
                is FirebaseResponse.Empty -> emit(ApiResponse.Empty())
            }
        }
    }.flowOn(Dispatchers.IO)

    suspend fun signInUser(email: String, password: String): Flow<ApiResponse<UserResponse>> = flow {
        firebaseService.signInWithEmailAndPassword(email, password).collect { response ->
            when(response) {
                is FirebaseResponse.Success -> {
                    try {
                        val userResponse = apiService.getDetailUser(response.data).data
                        emit(ApiResponse.Success(userResponse))
                    } catch (e: Exception) {
                        emit(ApiResponse.Error(e.message.toString()))
                    }
                }
                is FirebaseResponse.Error -> emit(ApiResponse.Error(response.errorMessage))
                is FirebaseResponse.Empty -> emit(ApiResponse.Empty())
            }
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getDetailUser(uid: String): Flow<ApiResponse<UserResponse>> = flow {
        try {
            val response = apiService.getDetailUser(uid)
            val user = response.data
            emit(ApiResponse.Success(user))
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}