package com.oreyo.foodie.data.source.remote.api.response

import com.google.gson.annotations.SerializedName

data class GeneralListResponse<T>(
	@SerializedName("status")
	var status: String = "",
	
	@SerializedName("message")
	val message: String = "",
	
	@SerializedName("count")
	val count: Int = 0,
	
	@SerializedName("data")
	val data: List<T>

)
