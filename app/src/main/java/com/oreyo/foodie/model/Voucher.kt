package com.oreyo.foodie.model

data class Voucher(
    val voucherId: String,
    val background: String,
    val xpCost: Int,
    val validUntil: String,
    val voucherCategory: String,
    val voucherDiscount: Int,
)
