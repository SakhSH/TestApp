package com.example.testapp.home.listmenu

import androidx.recyclerview.widget.DiffUtil
import javax.inject.Inject

class ListItemDiffCallback @Inject constructor() : DiffUtil.ItemCallback<BannerItem>() {
    override fun areItemsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
        return oldItem == newItem
    }


}