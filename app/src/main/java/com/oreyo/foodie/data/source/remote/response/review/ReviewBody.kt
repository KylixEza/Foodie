package com.oreyo.foodie.data.source.remote.response.review

import com.google.gson.annotations.SerializedName

data class ReviewBody(
	
	@field:SerializedName("uid")
	val uid: String,
	
	@field:SerializedName("rating")
	val rating: Double
)
