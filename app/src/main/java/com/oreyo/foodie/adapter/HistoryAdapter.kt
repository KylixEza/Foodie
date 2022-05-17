package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oreyo.foodie.R
import com.oreyo.foodie.adapter.callback.HistoryDiffCallback
import com.oreyo.foodie.databinding.ItemListHistoryBinding
import com.oreyo.foodie.model.History
import com.oreyo.foodie.util.OrderStatus

class HistoryAdapter: BaseRecyclerViewAdapter<ItemListHistoryBinding, History>() {

    override fun inflateViewBinding(parent: ViewGroup): ItemListHistoryBinding {
        return ItemListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override val binder: (History, View, ItemListHistoryBinding) -> Unit = { history, itemView, view ->
        view.apply {
            Glide.with(itemView.context)
                .load(history.image)
                .into(view.ivImgMenu)

            tvRating.text = history.rating.toString()
            tvTitle.text = history.title
            tvOrderTime.text = history.timeStamp
            tvVariant.text = history.variant
            tvStatus.text = history.status
            //Decision of status, write code below
            when (history.status) {
                OrderStatus.OnProcess.status -> {
                    cvStatus.setBackgroundColor(itemView.resources.getColor(R.color.card_on_process))
                    btnDecision.apply {
                        setBackgroundColor(itemView.resources.getColor(R.color.card_on_order_cancel))
                        setOnClickListener {
                            //TODO: Update status to API
                        }
                    }
                }
                OrderStatus.Success.status -> {
                    cvStatus.setBackgroundColor(itemView.resources.getColor(R.color.card_on_success))
                    btnDecision.apply {
                        setBackgroundColor(itemView.resources.getColor(R.color.card_on_order_again))
                        setOnClickListener {
                            //TODO: Update status to API
                        }
                    }
                    includeSendRating.apply {
                        root.visibility = View.VISIBLE
                        btnSendRating.setOnClickListener {
                            //TODO: Open Bottom Fragment To Review
                        }
                    }
                }
                OrderStatus.Cancel.status -> {
                    cvStatus.setBackgroundColor(itemView.resources.getColor(R.color.card_on_canceled))
                    btnDecision.visibility = View.INVISIBLE
                }
            }
        }
    }

    override val diffUtilBuilder: (List<History>, List<History>) -> DiffUtil.Callback
        get() = { old, new -> HistoryDiffCallback(old, new) }
}