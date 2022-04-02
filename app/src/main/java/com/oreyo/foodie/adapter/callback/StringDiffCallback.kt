package com.oreyo.foodie.adapter.callback

import androidx.recyclerview.widget.DiffUtil

class StringDiffCallback(
    private val oldItemList: List<String>,
    private val newItemList: List<String>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldItemList.size

    override fun getNewListSize(): Int = newItemList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemList[oldItemPosition].hashCode() == newItemList[newItemPosition].hashCode()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemList[oldItemPosition] == newItemList[newItemPosition]
    }
}