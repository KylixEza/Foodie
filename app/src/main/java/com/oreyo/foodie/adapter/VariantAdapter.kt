package com.oreyo.foodie.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.oreyo.foodie.util.Formatting
import com.oreyo.foodie.adapter.callback.VariantDiffCallback
import com.oreyo.foodie.databinding.FragmentDetailVariantBinding
import com.oreyo.foodie.databinding.ItemListVariantBinding
import com.oreyo.foodie.model.Variant
import com.oreyo.foodie.presentation.detail.variant.DetailVariantFragmentDirections

class VariantAdapter(
    private val binding: FragmentDetailVariantBinding,
    ) : BaseRecyclerViewAdapter<ItemListVariantBinding, Variant>() {

    private var selectedItem = -1

    override fun inflateViewBinding(parent: ViewGroup): ItemListVariantBinding {
        return ItemListVariantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override val binder: (Variant, View, ItemListVariantBinding) -> Unit
        @SuppressLint("NotifyDataSetChanged")
        get() = { variant, itemView, view ->
            view.apply {
                tvTittleVariant.text = variant.variant
                tvSubtitleVariant.text = variant.composition
                tvVariantPrice.text = Formatting.rupiahCurrencyFormatting(variant.price)
                Glide.with(itemView.context)
                    .load(variant.image)
                    .centerCrop()
                    .into(view.ivVariantImg)

                view.rbVariant.setOnClickListener {
                    selectedItem = position
                    /*viewModel.getVariantMenu(variant.menuName).observe(owner.viewLifecycleOwner, {
                        when(it) {
                            is Resource.Empty -> {}
                            is Resource.Error -> {}
                            is Resource.Loading -> {}
                            is Resource.Success -> {
                                binding
                                    .includeBottomBarDetail
                                    .availabilityStatus
                                    .text = Formatting.rupiahCurrencyFormatting(variant.price)
                            }
                        }*/
                    notifyDataSetChanged()
                }
                rbVariant.isChecked = (position == selectedItem)
            }

            binding.includeBottomBarDetail.btnOrder.setOnClickListener {
                if (selectedItem != -1) {
                    val selectedVariant = itemList[selectedItem]
                    it.findNavController().navigate(DetailVariantFragmentDirections
                        .actionDetailVariantMenuFragmentToDetailOrderMenuFragment(selectedVariant))
                }
            }
        }
    override val diffUtilBuilder: (List<Variant>, List<Variant>) -> DiffUtil.Callback
        get() = { old, new -> VariantDiffCallback(old, new) }
}