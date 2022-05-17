package com.oreyo.foodie.adapter.callback

import com.oreyo.foodie.model.Voucher

class VoucherDiffCallback(
    oldVoucherList: List<Voucher>,
    newVoucherList: List<Voucher>
): BaseDiffUtilCallback<Voucher, String, Int>(oldVoucherList, newVoucherList) {

    override fun Voucher.getItemIdentifier(): String = this.voucherId

    override fun Voucher.getContentIdentifier(): Int = this.voucherDiscount
}
