package com.oreyo.foodie.adapter.callback

import com.oreyo.foodie.model.Variant

class VariantDiffCallback(
    oldVariantList: List<Variant>,
    newVariantList: List<Variant>
): BaseDiffUtilCallback<Variant, Int, String>(oldVariantList, newVariantList) {

    override fun Variant.getItemIdentifier(): Int = this.hashCode()

    override fun Variant.getContentIdentifier(): String = this.variant
}