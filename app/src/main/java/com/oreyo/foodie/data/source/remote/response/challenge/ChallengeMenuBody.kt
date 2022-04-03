package com.oreyo.foodie.data.source.remote.response.challenge

import com.google.gson.annotations.SerializedName

data class ChallengeMenuBody(
	
	@field:SerializedName("menu_id")
	val menuId: String,
	
	@field:SerializedName("challenge_id")
	val challengeId: String,
	
	@field:SerializedName("type")
	val type: String,
)
