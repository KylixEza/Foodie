package com.oreyo.foodie.data.source.remote.response.challenge_user

import com.google.gson.annotations.SerializedName

data class ChallengeUserBody(
	@field:SerializedName("uid")
	val uid: String
)
