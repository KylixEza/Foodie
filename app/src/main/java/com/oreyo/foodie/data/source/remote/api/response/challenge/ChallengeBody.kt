package com.oreyo.foodie.data.source.remote.api.response.challenge

import com.google.gson.annotations.SerializedName

data class ChallengeBody(
	@field:SerializedName("title")
	val title: String,
	
	@field:SerializedName("description")
	val description: String,
	
	@field:SerializedName("xp_earned")
	val xpEarned: Int,
)
