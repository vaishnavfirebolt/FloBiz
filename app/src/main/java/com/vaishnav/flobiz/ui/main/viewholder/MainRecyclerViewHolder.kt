package com.vaishnav.flobiz.ui.main.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.vaishnav.flobiz.databinding.AdsItemBinding
import com.vaishnav.flobiz.databinding.RvItemBinding
import com.vaishnav.flobiz.model.RecyclerViewData
import java.text.SimpleDateFormat
import java.util.*

sealed class MainRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    var itemClickListener: ((view: View, item: RecyclerViewData, position: Int) -> Unit)? = null

    class QuestionViewHolder(private val binding: RvItemBinding) : MainRecyclerViewHolder(binding) {
        fun bind(item: RecyclerViewData.Ques) {
            val date = item.creation_date?.let { Date(it) }
            val df2 = SimpleDateFormat("dd/MM/yy")
            val dateText: String = df2.format(date)
            binding.tvDate.text = "Posted On ${dateText}"
            binding.tvOwnerName.text = item.owner!!.display_name
            binding.tvTitle.text = item.title
            Glide.with(binding.ivOwnerImage).load(item.owner!!.profile_image)
                .into(binding.ivOwnerImage)
            binding.rvItemConstraintLayout.setOnClickListener {
                itemClickListener?.invoke(it, item, adapterPosition)
            }
        }
    }

    class AdViewHolder(private val binding: AdsItemBinding) : MainRecyclerViewHolder(binding) {
        fun bind(ad: RecyclerViewData.Ad) {
            Glide.with(binding.ivAd).load(ad.imageLink).into(binding.ivAd)
            binding.ivCancel.setOnClickListener {
                itemClickListener?.invoke(it, ad, adapterPosition)
            }
        }
    }
}