package com.oreyo.foodie.adapter.callback

import com.oreyo.foodie.model.Review

class ReviewDiffCallback(
    oldItemList: List<Review>,
    newItemList: List<Review>
): BaseDiffUtilCallback<Review, Int, String>(oldItemList, newItemList) {

    override fun Review.getItemIdentifier(): Int = this.hashCode()

    override fun Review.getContentIdentifier(): String = this.username
}