package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.oreyo.foodie.adapter.callback.StringDiffCallback
import com.oreyo.foodie.databinding.ItemListStepBinding

class StepAdapter: BaseRecyclerViewAdapter<ItemListStepBinding, String>() {

    override fun inflateViewBinding(parent: ViewGroup): ItemListStepBinding {
        return ItemListStepBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override val binder: (String, View, ItemListStepBinding) -> Unit
        get() = {step, _, view ->
            view.apply {
                tvOrderedNumber.text = position.plus(1).toString()
                tvIngredient.text = step
            }
        }

    override val diffUtilBuilder: (List<String>, List<String>) -> DiffUtil.Callback
        get() = { old, new -> StringDiffCallback(old, new) }
}