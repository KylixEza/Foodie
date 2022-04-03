package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oreyo.foodie.R
import com.oreyo.foodie.adapter.callback.LeaderboardCallback
import com.oreyo.foodie.databinding.ItemListLeaderboardBinding
import com.oreyo.foodie.model.Leaderboard

class LeaderboardAdapter: RecyclerView.Adapter<LeaderboardAdapter.LeaderBoardViewHolder>() {

    private val listOfLeaderboard = ArrayList<Leaderboard>()

    fun setAllData(data: List<Leaderboard>) {
        val diffCallback = LeaderboardCallback(listOfLeaderboard, data)
        val diffRate = DiffUtil.calculateDiff(diffCallback)

        listOfLeaderboard.apply {
            clear()
            addAll(data)
        }
        diffRate.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LeaderBoardViewHolder {
        val view = ItemListLeaderboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LeaderBoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeaderBoardViewHolder, position: Int) {
        holder.bind(listOfLeaderboard[position], position)
    }

    override fun getItemCount(): Int = listOfLeaderboard.size

    class LeaderBoardViewHolder(val view: ItemListLeaderboardBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(leaderboard: Leaderboard, position: Int) {
            val rank = position + 1
            when (rank) {
                1 -> {
                    view.apply {
                        tvRank.visibility = View.INVISIBLE
                        ivRank.setImageResource(R.drawable.ic_rank_first)
                        Glide.with(itemView.context)
                            .load(leaderboard.avatarUrl)
                            .placeholder(R.drawable.ilu_default_profile_picture)
                            .into(ivAvatar)
                        tvAccountName.text = leaderboard.name
                        tvXpPoints.text = String.format("${leaderboard.xp} XP")
                    }
                }
                2 -> {
                    view.apply {
                        tvRank.visibility = View.INVISIBLE
                        ivRank.setImageResource(R.drawable.ic_rank_second)
                        Glide.with(itemView.context)
                            .load(leaderboard.avatarUrl)
                            .placeholder(R.drawable.ilu_default_profile_picture)
                            .into(ivAvatar)
                        tvAccountName.text = leaderboard.name
                        tvXpPoints.text = String.format("${leaderboard.xp} XP")
                    }
                }
                3 -> {
                    view.apply {
                        tvRank.visibility = View.INVISIBLE
                        ivRank.setImageResource(R.drawable.ic_rank_third)
                        Glide.with(itemView.context)
                            .load(leaderboard.avatarUrl)
                            .placeholder(R.drawable.ilu_default_profile_picture)
                            .into(ivAvatar)
                        tvAccountName.text = leaderboard.name
                        tvXpPoints.text = String.format("${leaderboard.xp} XP")
                    }
                }
                else -> {
                    view.apply {
                        tvRank.text = rank.toString()
                        ivRank.visibility = View.INVISIBLE
                        Glide.with(itemView.context)
                            .load(leaderboard.avatarUrl)
                            .placeholder(R.drawable.ilu_default_profile_picture)
                            .into(ivAvatar)
                        tvAccountName.text = leaderboard.name
                        tvXpPoints.text = String.format("${leaderboard.xp} XP")
                    }
                }
            }
        }
    }
}