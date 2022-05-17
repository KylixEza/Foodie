package com.oreyo.foodie.adapter.callback

class StringDiffCallback(
    oldItemList: List<String>,
    newItemList: List<String>
): BaseDiffUtilCallback<String, Int, String>(oldItemList, newItemList) {

    override fun String.getItemIdentifier(): Int = this.hashCode()

    override fun String.getContentIdentifier(): String = this
}