package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oreyo.foodie.adapter.callback.HistoryCallback
import com.oreyo.foodie.databinding.ItemListHistoryBinding
import com.oreyo.foodie.model.History

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val historyList = ArrayList<History>()

    fun setAllData(data: List<History>) {
        val diffCallback = HistoryCallback(historyList, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        historyList.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    inner class HistoryViewHolder(private val view: ItemListHistoryBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(history: History) {
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
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = ItemListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyList[position])
    }

    override fun getItemCount(): Int = historyList.size
}