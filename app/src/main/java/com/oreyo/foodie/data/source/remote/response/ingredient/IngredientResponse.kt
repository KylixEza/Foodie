package com.oreyo.foodie.data.source.remote.response.ingredient

import com.google.gson.annotations.SerializedName

data class IngredientResponse(
	
	@field:SerializedName("menu_id")
	val menuId: String,
	
	@field:SerializedName("ingredient")
	val ingredient: String
)
