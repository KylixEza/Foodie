package com.oreyo.foodie.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(

    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "avatar")
    val avatar: String,

    @ColumnInfo(name = "foodie_wallet")
    val foodieWallet: Int,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,

    @ColumnInfo(name = "xp")
    val xp: Int
)
