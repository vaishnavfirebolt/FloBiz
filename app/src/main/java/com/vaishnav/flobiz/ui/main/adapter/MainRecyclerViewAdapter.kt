package com.vaishnav.flobiz.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vaishnav.flobiz.R
import com.vaishnav.flobiz.databinding.AdsItemBinding
import com.vaishnav.flobiz.databinding.RvItemBinding
import com.vaishnav.flobiz.model.RecyclerViewData
import com.vaishnav.flobiz.ui.main.viewholder.MainRecyclerViewHolder

class MainRecyclerViewAdapter : RecyclerView.Adapter<MainRecyclerViewHolder>() {

    var items = listOf<RecyclerViewData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var itemClickListener: ((view: View, item: RecyclerViewData, position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return when (viewType) {
            R.layout.rv_item -> MainRecyclerViewHolder.QuestionViewHolder(
                RvItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.ads_item -> MainRecyclerViewHolder.AdViewHolder(
                AdsItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
        holder.itemClickListener = itemClickListener
        when (holder) {
            is MainRecyclerViewHolder.QuestionViewHolder -> holder.bind(items[position] as RecyclerViewData.Ques)
            is MainRecyclerViewHolder.AdViewHolder -> holder.bind(items[position] as RecyclerViewData.Ad)
        }
    }

    override fun getItemCount() = items.size
    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is RecyclerViewData.Ques -> R.layout.rv_item
            is RecyclerViewData.Ad -> R.layout.ads_item

        }
    }

}