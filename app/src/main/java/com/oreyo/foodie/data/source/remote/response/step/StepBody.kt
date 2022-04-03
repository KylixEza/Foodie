package com.oreyo.foodie.data.source.remote.response.step

import com.google.gson.annotations.SerializedName

data class StepBody(
	@field:SerializedName("step")
	val step: String
)
