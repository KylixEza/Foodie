package com.oreyo.foodie.data.source.remote.api.service

import com.oreyo.foodie.data.source.remote.api.response.GeneralResponse
import com.oreyo.foodie.data.source.remote.api.response.user.UserBody
import com.oreyo.foodie.data.source.remote.api.response.user.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("/user")
    suspend fun postNewUser(
        @Body body: UserBody
    ): GeneralResponse<String>

    @GET("/user/{uid}")
    suspend fun getDetailUser(
        @Path("uid") uid: String
    ): GeneralResponse<UserResponse>
}