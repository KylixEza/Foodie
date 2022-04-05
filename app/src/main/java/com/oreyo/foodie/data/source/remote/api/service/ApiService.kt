package com.oreyo.foodie.data.source.remote.api.service

import com.oreyo.foodie.data.source.remote.api.response.GeneralListResponse
import com.oreyo.foodie.data.source.remote.api.response.GeneralResponse
import com.oreyo.foodie.data.source.remote.api.response.coupon.CouponResponse
import com.oreyo.foodie.data.source.remote.api.response.menu.MenuResponse
import com.oreyo.foodie.data.source.remote.api.response.user.UserBody
import com.oreyo.foodie.data.source.remote.api.response.user.UserResponse
import retrofit2.http.*

interface ApiService {

    @POST("/user")
    suspend fun postNewUser(
        @Body body: UserBody
    ): GeneralResponse<String>

    @GET("/user/{uid}")
    suspend fun getDetailUser(
        @Path("uid") uid: String
    ): GeneralResponse<UserResponse>

    @GET("/user")
    suspend fun getSearchMenus(
        @Query("query") query: String
    ): GeneralListResponse<MenuResponse>

    @GET("/coupon")
    suspend fun getCoupons(): GeneralListResponse<CouponResponse>

    @GET("menu/diet")
    suspend fun getDietMenus(): GeneralListResponse<MenuResponse>

    @GET("menu/popular")
    suspend fun getPopularMenus(): GeneralListResponse<MenuResponse>

    @GET("menu/exclusive")
    suspend fun getExclusiveMenus(): GeneralListResponse<MenuResponse>

    @GET("menu/category")
    suspend fun getCategoryMenus(): GeneralListResponse<MenuResponse>

    @GET("menu/category")
    suspend fun getCategoryMenus(
        @Query("category") category: String
    ): GeneralListResponse<MenuResponse>
}