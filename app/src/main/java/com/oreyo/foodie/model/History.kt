package com.oreyo.foodie.model

data class History(
    val transactionId: String,
    val menuId: String,
    val timeStamp: String,
    val title: String,
    val image: String,
    val rating: Double,
    val variant: String,
    val status: String,
    val starsGiven: Int
)
