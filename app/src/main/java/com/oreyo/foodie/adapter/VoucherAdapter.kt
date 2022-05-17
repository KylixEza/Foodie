package com.oreyo.foodie.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.oreyo.foodie.R
import com.oreyo.foodie.adapter.callback.VoucherDiffCallback
import com.oreyo.foodie.databinding.ItemListVoucherBinding
import com.oreyo.foodie.model.Voucher
import com.oreyo.foodie.presentation.voucher.detail.DetailVoucherActivity
import com.oreyo.foodie.util.VoucherBackground

class VoucherAdapter : BaseRecyclerViewAdapter<ItemListVoucherBinding, Voucher>() {

    override fun inflateViewBinding(parent: ViewGroup): ItemListVoucherBinding {
        return ItemListVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override val binder: (Voucher, View, ItemListVoucherBinding) -> Unit
        @SuppressLint("SetTextI18n")
        get() = { item, itemView, view ->
            with(view) {
                tvCoin.text = item.xpCost.toString()
                tvValidUntil.text = item.validUntil
                tvVoucherCategory.text = item.voucherCategory
                tvVoucherDiscount.text = "Discount ${item.voucherDiscount}%"

                when (item.background) {
                    VoucherBackground.Voucher1.style -> layoutTiket.setBackgroundResource(
                        R.drawable.ic_background_voucher1)
                    VoucherBackground.Voucher2.style -> layoutTiket.setBackgroundResource(
                        R.drawable.ic_background_voucher2)
                    VoucherBackground.Voucher3.style -> layoutTiket.setBackgroundResource(
                        R.drawable.ic_background_vouchre3)
                }

            }
            view.btnDetail.setOnClickListener {
                val intent = Intent(itemView.context, DetailVoucherActivity::class.java)
                intent.putExtra(DetailVoucherActivity.DETAIL_VOUCHER, item.voucherId)
                itemView.context.startActivity(intent)
            }
        }
    override val diffUtilBuilder: (List<Voucher>, List<Voucher>) -> DiffUtil.Callback
        get() = { old, new -> VoucherDiffCallback(old, new) }
}