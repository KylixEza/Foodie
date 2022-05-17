package com.oreyo.foodie.adapter.callback

import com.oreyo.foodie.model.Leaderboard

class LeaderboardDiffCallback(
    oldLeaderboardList: List<Leaderboard>,
    newLeaderboardList: List<Leaderboard>
): BaseDiffUtilCallback<Leaderboard, String, String>(oldLeaderboardList, newLeaderboardList) {

    override fun Leaderboard.getItemIdentifier(): String = this.uid

    override fun Leaderboard.getContentIdentifier(): String = this.name

}