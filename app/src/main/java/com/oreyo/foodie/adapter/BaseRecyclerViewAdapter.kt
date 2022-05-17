package com.oreyo.foodie.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlin.properties.Delegates

abstract class BaseRecyclerViewAdapter<VB: ViewBinding, ListType>
    : RecyclerView.Adapter<BaseRecyclerViewAdapter<VB, ListType>.BaseViewHolder>() {

    var position by Delegates.notNull<Int>()

    protected val itemList = arrayListOf<ListType>().toMutableList()

    protected abstract fun inflateViewBinding(
        parent: ViewGroup
    ): VB

    protected abstract val binder: (ListType, View, VB) -> Unit

    protected abstract val diffUtilBuilder: (List<ListType>, List<ListType>) -> DiffUtil.Callback

    fun setAllData(data: List<ListType>) {
        val diffCallback = diffUtilBuilder(itemList, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        itemList.apply {
            clear()
            addAll(data)
        }

        diffResult.dispatchUpdatesTo(this)
    }

    inner class BaseViewHolder(val view: VB): RecyclerView.ViewHolder(view.root) {
        fun bind(item: ListType) {
            binder(item, itemView, view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = inflateViewBinding(parent)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        this.position = position
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

}