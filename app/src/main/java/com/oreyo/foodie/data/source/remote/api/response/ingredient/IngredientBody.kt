package com.oreyo.foodie.data.source.remote.api.response.ingredient

import com.google.gson.annotations.SerializedName

data class IngredientBody(
	@field:SerializedName("ingredient")
	val ingredient: String
)
