package com.oreyo.foodie.data.source.remote.api.response.user

import com.google.gson.annotations.SerializedName

data class EditAddressBody(
	
	@field:SerializedName("address")
	val address: String
)
