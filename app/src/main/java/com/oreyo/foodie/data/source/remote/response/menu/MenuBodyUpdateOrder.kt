package com.oreyo.foodie.data.source.remote.response.menu

import com.google.gson.annotations.SerializedName

data class MenuBodyUpdateOrder(
	@field:SerializedName("ordered")
	val ordered: Int
)
