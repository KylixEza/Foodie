package com.oreyo.foodie.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GeneralResponse<T>(
	@SerializedName("status")
	val status: String = "",
	
	@SerializedName("message")
	val message: String = "",
	
	@SerializedName("data")
	val data: T?
	
)
