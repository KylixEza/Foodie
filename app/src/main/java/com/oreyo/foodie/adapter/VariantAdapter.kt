package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kinderjoey.cookiez.util.Formatting
import com.oreyo.foodie.databinding.FragmentDetailVariantBinding
import com.oreyo.foodie.databinding.ItemListVariantBinding
import com.oreyo.foodie.model.Variant
import com.oreyo.foodie.presentation.detail.variant.DetailVariantFragmentDirections

class VariantAdapter(
    private val owner: Fragment,
    private val binding: FragmentDetailVariantBinding,
    ) : RecyclerView.Adapter<VariantAdapter.VariantViewHolder>() {

    private val listOfVariants = ArrayList<Variant>()
    private var selectedItem = -1

    fun setAllData(data: List<Variant>) {
        listOfVariants.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariantViewHolder {
        val view = ItemListVariantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VariantViewHolder(view)
    }

    override fun onBindViewHolder(holder: VariantViewHolder, position: Int) {
        holder.bind(listOfVariants[position], position)
    }

    override fun getItemCount(): Int = listOfVariants.size

    inner class VariantViewHolder(val view: ItemListVariantBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(variant: Variant, position: Int) {
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
                    val selectedVariant = listOfVariants[selectedItem]
                    it.findNavController().navigate(DetailVariantFragmentDirections
                        .actionDetailVariantMenuFragmentToDetailOrderMenuFragment(selectedVariant))
                }
            }
        }
    }
}