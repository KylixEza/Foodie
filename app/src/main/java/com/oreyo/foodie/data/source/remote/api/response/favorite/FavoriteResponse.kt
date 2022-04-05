package com.oreyo.foodie.data.source.remote.api.response.favorite

import com.google.gson.annotations.SerializedName

data class FavoriteResponse(
	@field:SerializedName("uid")
	val uid: String,
	
	@field:SerializedName("menu_id")
	val menuId: String
)
