package com.oreyo.foodie.data.source.remote.response.voucher

import com.google.gson.annotations.SerializedName

data class VoucherResponse(
	
	@field:SerializedName("voucher_id")
	val voucherId: String,
	
	@field:SerializedName("background")
	val background: String,
	
	@field:SerializedName("xp_cost")
	val xpCost: Int,
	
	@field:SerializedName("valid_until")
	val validUntil: String,
	
	@field:SerializedName("voucher_category")
	val voucherCategory: String,
	
	@field:SerializedName("voucher_discount")
	val voucherDiscount: Int,
)