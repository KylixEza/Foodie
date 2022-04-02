package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oreyo.foodie.databinding.ItemListCategoryBinding
import com.oreyo.foodie.model.Category
import com.oreyo.foodie.presentation.home.HomeFragmentDirections

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val listOfCategory = ArrayList<Category>()

    fun setAllData(data: List<Category>) {
        listOfCategory.apply {
            clear()
            addAll(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = ItemListCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(listOfCategory[position])
    }

    override fun getItemCount(): Int = listOfCategory.size

    inner class CategoryViewHolder(private val view: ItemListCategoryBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(category: Category) {
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
}