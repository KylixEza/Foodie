package com.oreyo.foodie.data.source.remote.response.history

import com.google.gson.annotations.SerializedName

data class HistoryUpdateBody(
	
	@SerializedName("transaction_id")
	val transactionId: String,
	
	@SerializedName("status")
	val status: String,
)