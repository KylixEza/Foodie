package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oreyo.foodie.adapter.callback.CategoryDiffCallback
import com.oreyo.foodie.databinding.ItemListCategoryBinding
import com.oreyo.foodie.model.Category
import com.oreyo.foodie.presentation.home.HomeFragmentDirections

class CategoryAdapter: BaseRecyclerViewAdapter<ItemListCategoryBinding, Category>() {

    override fun inflateViewBinding(parent: ViewGroup): ItemListCategoryBinding {
        return ItemListCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override val diffUtilBuilder: (List<Category>, List<Category>) -> DiffUtil.Callback
        get() = { oldItem, newItem -> CategoryDiffCallback(oldItem, newItem) }

    override val binder: (Category, View, ItemListCategoryBinding) -> Unit = { category, itemView, view ->
            Glide.with(itemView.context)
                .load(category.categoryImage)
                .into(view.ivCategory)
            view.tvCategoryType.text = category.categoryTitle

            itemView.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections
                    .actionNavigationHomeToCategoryActivity(category.categoryTitle, category.categoryType))
            }
        }
}