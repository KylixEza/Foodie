package com.oreyo.foodie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.oreyo.foodie.adapter.callback.ReviewDiffCallback
import com.oreyo.foodie.databinding.ItemListReviewBinding
import com.oreyo.foodie.model.Review

class ReviewAdapter: BaseRecyclerViewAdapter<ItemListReviewBinding, Review>() {

    override fun inflateViewBinding(parent: ViewGroup): ItemListReviewBinding {
        return ItemListReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override val binder: (Review, View, ItemListReviewBinding) -> Unit = {review, itemView, view ->
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

    override val diffUtilBuilder: (List<Review>, List<Review>) -> DiffUtil.Callback
        get() = { old, new -> ReviewDiffCallback(old, new) }
}