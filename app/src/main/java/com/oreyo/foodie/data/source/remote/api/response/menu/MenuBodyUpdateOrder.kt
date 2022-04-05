package com.oreyo.foodie.data.source.remote.api.response.menu

import com.google.gson.annotations.SerializedName

data class MenuBodyUpdateOrder(
	@field:SerializedName("ordered")
	val ordered: Int
)
