package com.oreyo.foodie.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import com.oreyo.foodie.model.Variant

class VariantDiffCallback(
    private val oldVariantList: List<Variant>,
    private val newVariantList: List<Variant>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldVariantList.size

    override fun getNewListSize(): Int = newVariantList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldVariantList[oldItemPosition].hashCode() == newVariantList[newItemPosition].hashCode()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldVariantList[oldItemPosition].variant == newVariantList[newItemPosition].variant
}