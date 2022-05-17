package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.oreyo.foodie.adapter.callback.StringDiffCallback
import com.oreyo.foodie.databinding.ItemListIngredientBinding

class IngredientAdapter: BaseRecyclerViewAdapter<ItemListIngredientBinding, String>() {

    override fun inflateViewBinding(parent: ViewGroup): ItemListIngredientBinding {
        return ItemListIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override val binder: (String, View, ItemListIngredientBinding) -> Unit = {ingredient, _, view ->
        view.tvIngredient.text = ingredient
    }

    override val diffUtilBuilder: (List<String>, List<String>) -> DiffUtil.Callback
        get() = { old, new -> StringDiffCallback(old, new) }
}