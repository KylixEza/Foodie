package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oreyo.foodie.databinding.ItemListCouponBinding

class PromotionAdapter: RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder>() {

    private val listOfPromotion = ArrayList<String>()

    fun setAllData(data: List<String>) {
        listOfPromotion.apply {
            clear()
            addAll(data)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PromotionAdapter.PromotionViewHolder {
        val view = ItemListCouponBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromotionViewHolder(view)
    }

    override fun onBindViewHolder(holder: PromotionAdapter.PromotionViewHolder, position: Int) {
        holder.bind(listOfPromotion[position])
    }

    override fun getItemCount(): Int = listOfPromotion.size

    class PromotionViewHolder(val view: ItemListCouponBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(promotionCoupon: String) {
            Glide.with(itemView.context)
                .load(promotionCoupon)
                .into(view.ivPromote)
        }
    }

}