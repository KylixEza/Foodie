package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oreyo.foodie.R
import com.oreyo.foodie.adapter.callback.HistoryCallback
import com.oreyo.foodie.databinding.ItemListHistoryBinding
import com.oreyo.foodie.model.History
import com.oreyo.foodie.util.OrderStatus

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