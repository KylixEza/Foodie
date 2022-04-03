package com.oreyo.foodie.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.oreyo.foodie.R
import com.oreyo.foodie.adapter.callback.VoucherCallback
import com.oreyo.foodie.databinding.ItemListVoucherBinding
import com.oreyo.foodie.model.Voucher
import com.oreyo.foodie.presentation.voucher.detail.DetailVoucherActivity
import com.oreyo.foodie.util.VoucherBackground

class VoucherAdapter : RecyclerView.Adapter<VoucherAdapter.ListViewHolder>() {

    private val vouchers = ArrayList<Voucher>()

    fun setAllData(data: List<Voucher>) {
        val diffCallback = VoucherCallback(vouchers, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        vouchers.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemBinding =
            ItemListVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemBinding)
    }

    override fun getItemCount() = vouchers.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(vouchers[position])
    }


    inner class ListViewHolder(private val binding: ItemListVoucherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Voucher) {
            with(binding) {
                tvCoin.text = item.xpCost.toString()
                tvValidUntil.text = item.validUntil
                tvVoucherCategory.text = item.voucherCategory
                tvVoucherDiscount.text = "Discount ${item.voucherDiscount}%"

                when (item.background) {
                    VoucherBackground.Voucher1.style -> layoutTiket.setBackgroundResource(R.drawable.ic_background_voucher1)
                    VoucherBackground.Voucher2.style -> layoutTiket.setBackgroundResource(R.drawable.ic_background_voucher2)
                    VoucherBackground.Voucher3.style -> layoutTiket.setBackgroundResource(R.drawable.ic_background_vouchre3)
                }

            }
            binding.btnDetail.setOnClickListener {
                val intent = Intent(itemView.context, DetailVoucherActivity::class.java)
                intent.putExtra(DetailVoucherActivity.DETAIL_VOUCHER, item.voucherId)
                itemView.context.startActivity(intent)
            }
        }
    }
}