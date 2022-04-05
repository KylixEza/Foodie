package com.oreyo.foodie.data.source.remote.api.response.challenge

import com.google.gson.annotations.SerializedName
import com.oreyo.foodie.data.source.remote.api.response.menu.MenuResponse

data class ChallengeMenuResponse(
	
	@field:SerializedName("challenge_id")
	val challengeId: String,
	
	@field:SerializedName("menu_id")
	val menuId: String,
	
	@field:SerializedName("type")
	val type: String,
	
	@field:SerializedName("menus")
	val menus: List<MenuResponse>?
)
