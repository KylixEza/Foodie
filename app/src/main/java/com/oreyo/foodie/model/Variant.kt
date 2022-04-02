package com.oreyo.foodie.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Variant(
    val menuId: String,
    val variant: String,
    val composition: String,
    val price: Int,
    val image: String
): Parcelable
