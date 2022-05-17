package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oreyo.foodie.adapter.callback.StringDiffCallback
import com.oreyo.foodie.databinding.ItemListCouponBinding

class PromotionAdapter: BaseRecyclerViewAdapter<ItemListCouponBinding, String>() {

    override fun inflateViewBinding(parent: ViewGroup): ItemListCouponBinding {
        return ItemListCouponBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override val binder: (String, View, ItemListCouponBinding) -> Unit
        get() = { promotionCoupon, itemView, view ->
            Glide.with(itemView.context)
                .load(promotionCoupon)
                .into(view.ivPromote)
        }

    override val diffUtilBuilder: (List<String>, List<String>) -> DiffUtil.Callback
        get() = { old, new -> StringDiffCallback(old, new) }

}