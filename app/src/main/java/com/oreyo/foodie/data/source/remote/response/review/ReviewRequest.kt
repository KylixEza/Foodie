package com.oreyo.foodie.data.source.remote.response.review

import com.google.gson.annotations.SerializedName

data class ReviewRequest(
	@field:SerializedName("uid")
	val uid: String,
)
