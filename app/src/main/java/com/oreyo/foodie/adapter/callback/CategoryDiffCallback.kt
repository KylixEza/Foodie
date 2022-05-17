package com.oreyo.foodie.adapter.callback

import com.oreyo.foodie.model.Category

class CategoryDiffCallback(
    oldItemList: List<Category>,
    newItemList: List<Category>
): BaseDiffUtilCallback<Category, Int, String>(oldItemList, newItemList) {

    override fun Category.getItemIdentifier(): Int = this.categoryImage

    override fun Category.getContentIdentifier(): String = this.categoryTitle
}