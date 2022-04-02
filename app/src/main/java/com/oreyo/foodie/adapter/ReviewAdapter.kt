package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.oreyo.foodie.adapter.callback.ReviewDiffCallback
import com.oreyo.foodie.databinding.ItemListReviewBinding
import com.oreyo.foodie.model.Review

class ReviewAdapter: RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    private val listOfReview = ArrayList<Review>()

    fun setAllData(data: List<Review>) {
        val diffCallback = ReviewDiffCallback(listOfReview, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listOfReview.apply {
            clear()
            addAll(data)
            diffResult.dispatchUpdatesTo(this@ReviewAdapter)
        }

    }

    inner class ReviewViewHolder(val view: ItemListReviewBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(review: Review) {
            view.apply {
                Glide.with(itemView.context)
                    .load(review.avatarUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivImageReviewer)

                tvNameReviewer.text = review.username
                ratingBar.rating = review.rating.toFloat()
                tvRating.text = review.rating.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = ItemListReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(listOfReview[position])
    }

    override fun getItemCount(): Int = listOfReview.size
}