package com.oreyo.foodie.util

import com.oreyo.foodie.data.source.local.database.entity.UserEntity
import com.oreyo.foodie.data.source.remote.api.response.user.UserBody
import com.oreyo.foodie.data.source.remote.api.response.user.UserResponse
import com.oreyo.foodie.model.User

fun UserResponse.toUserEntity() = UserEntity(
    uid, address, avatar, foodieWallet, email, name, phoneNumber, xp
)

fun User.toUserBody() = UserBody(
    uid, address, avatar, email, name, phoneNumber,
)
