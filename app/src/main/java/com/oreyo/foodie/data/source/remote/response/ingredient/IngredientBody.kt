package com.oreyo.foodie.data.source.remote.response.ingredient

import com.google.gson.annotations.SerializedName

data class IngredientBody(
	@field:SerializedName("ingredient")
	val ingredient: String
)
