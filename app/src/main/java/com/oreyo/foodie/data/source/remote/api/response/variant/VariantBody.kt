package com.oreyo.foodie.data.source.remote.api.response.variant

import com.google.gson.annotations.SerializedName

data class VariantBody(
	@field:SerializedName("composition")
	val composition: String,
	
	@field:SerializedName("image")
	val image: String,
	
	@field:SerializedName("price")
	val price: Int,
	
	@field:SerializedName("variant")
	val variant: String,
)
