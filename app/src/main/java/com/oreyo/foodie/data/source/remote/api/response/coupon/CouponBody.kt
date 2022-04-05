package com.oreyo.foodie.data.source.remote.api.response.coupon

import com.google.gson.annotations.SerializedName

data class CouponBody(
	
	@field:SerializedName("image_url")
	val imageUrl: String
)
