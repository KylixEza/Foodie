package com.oreyo.foodie.adapter.callback

import com.oreyo.foodie.model.History

class HistoryDiffCallback(
    oldHistoryList: List<History>,
    newHistoryList: List<History>
): BaseDiffUtilCallback<History, String, String>(oldHistoryList, newHistoryList) {

    override fun History.getItemIdentifier(): String = this.transactionId

    override fun History.getContentIdentifier(): String = this.status
}