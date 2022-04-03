package com.oreyo.foodie.data.source.remote.response.favorite

import com.google.gson.annotations.SerializedName

data class FavoriteBody(
	@field:SerializedName("menu_id")
	val menuId: String
)
