package com.oreyo.foodie.data.source.remote.api.response.leaderboard

import com.google.gson.annotations.SerializedName

data class LeaderBoardResponse(
	
	@field:SerializedName("uid")
	val uid: String,
	
	@field:SerializedName("name")
	val name: String,
	
	@field:SerializedName("avatar_url")
	val avatarUrl: String,
	
	@field:SerializedName("xp")
	val xp: Int
)
