package com.example.testapp.home.bannerlist

import androidx.recyclerview.widget.DiffUtil
import com.example.testapp.home.listmenu.BannerItem
import javax.inject.Inject

class BannerItemDiffCallback @Inject constructor() : DiffUtil.ItemCallback<BannerItem>() {
    override fun areItemsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BannerItem, newItem: BannerItem): Boolean {
        return oldItem == newItem
    }


}