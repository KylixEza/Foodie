package com.oreyo.foodie.data.source.remote.response.note

import com.google.gson.annotations.SerializedName

data class NoteResponse(
	
	@field:SerializedName("uid")
	val uid: String,
	
	@field:SerializedName("note_id")
	val noteId: String,
	
	@field:SerializedName("category")
	val category: String,
	
	@field:SerializedName("calories")
	val calories: Double,
	
	@field:SerializedName("date")
	val date: String,
	
	@field:SerializedName("food")
	val food: String,
	
	@field:SerializedName("information")
	val information: String,
	
	@field:SerializedName("portion")
	val portion: Double,
	
	@field:SerializedName("time")
	val time: String
)