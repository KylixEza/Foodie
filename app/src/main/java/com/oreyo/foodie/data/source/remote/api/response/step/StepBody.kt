package com.oreyo.foodie.data.source.remote.api.response.step

import com.google.gson.annotations.SerializedName

data class StepBody(
	@field:SerializedName("step")
	val step: String
)
