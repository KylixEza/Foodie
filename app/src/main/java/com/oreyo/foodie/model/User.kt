package com.oreyo.foodie.model

import com.google.gson.annotations.SerializedName

data class User(
    val uid: String = "",
    val address: String = "",
    val avatar: String = "",
    val foodieWallet: Int = 0,
    val email: String = "",
    val name: String = "",
    val phoneNumber: String = "",
    val xp: Int = 0
)
