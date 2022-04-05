package com.oreyo.foodie.data.source.remote.api.response.voucher_user

import com.google.gson.annotations.SerializedName

data class VoucherUserBody(
	@field:SerializedName("voucher_id")
	val voucherId: String,
	
	@field:SerializedName("uid")
	val uid: String
)
