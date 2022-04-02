package com.oreyo.foodie.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import com.oreyo.foodie.model.Review

class ReviewDiffCallback(
    private val oldItemList: List<Review>,
    private val newItemList: List<Review>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldItemList.size

    override fun getNewListSize(): Int = newItemList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemList[oldItemPosition].hashCode() == newItemList[newItemPosition].hashCode()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemList[oldItemPosition].username == newItemList[newItemPosition].username
    }
}