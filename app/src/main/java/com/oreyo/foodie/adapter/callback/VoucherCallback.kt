package com.oreyo.foodie.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import com.oreyo.foodie.model.Voucher

data class VoucherCallback(
    private val oldVoucherList: List<Voucher>,
    private val newVoucherList: List<Voucher>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldVoucherList.size

    override fun getNewListSize(): Int = newVoucherList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldVoucherList[oldItemPosition].voucherId == newVoucherList[newItemPosition].voucherId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldVoucherList[oldItemPosition].voucherCategory == newVoucherList[newItemPosition].voucherCategory
                || oldVoucherList[oldItemPosition].voucherDiscount ==  newVoucherList[newItemPosition].voucherDiscount
}
