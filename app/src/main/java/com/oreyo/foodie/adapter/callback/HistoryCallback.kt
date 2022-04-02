package com.oreyo.foodie.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import com.oreyo.foodie.model.History

class HistoryCallback(
    private val oldHistoryList: List<History>,
    private val newHistoryList: List<History>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldHistoryList.size

    override fun getNewListSize(): Int = newHistoryList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldHistoryList[oldItemPosition].transactionId == newHistoryList[newItemPosition].transactionId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldHistoryList[oldItemPosition].status == newHistoryList[newItemPosition].status
                || oldHistoryList[oldItemPosition].title == newHistoryList[newItemPosition].title
}