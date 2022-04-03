package com.oreyo.foodie.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import com.oreyo.foodie.model.Leaderboard

class LeaderboardCallback(
    private val oldLeaderboardList: List<Leaderboard>,
    private val newLeaderboardList: List<Leaderboard>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldLeaderboardList.size

    override fun getNewListSize(): Int = newLeaderboardList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldLeaderboardList[oldItemPosition].uid == newLeaderboardList[newItemPosition].uid

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldLeaderboardList[oldItemPosition].name == newLeaderboardList[newItemPosition].name
}