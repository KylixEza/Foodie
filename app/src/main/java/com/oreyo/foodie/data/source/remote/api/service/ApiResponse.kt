package com.oreyo.foodie.data.source.remote.api.service

sealed class ApiResponse<out T> {
    data class Success<out T> (val data: T): ApiResponse<T>()
    data class Error(val errorMessage: String): ApiResponse<Nothing>()
    data class Empty(val message: String = ""): ApiResponse<Nothing>()
}