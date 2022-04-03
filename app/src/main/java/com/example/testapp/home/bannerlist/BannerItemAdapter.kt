package com.example.testapp.home.listmenu

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.testapp.databinding.ItemListMenuBinding
import com.example.testapp.home.bannerlist.BannerItemDiffCallback
import javax.inject.Inject

class BannerItemAdapter @Inject constructor(callback: BannerItemDiffCallback)
    : androidx.recyclerview.widget.ListAdapter<BannerItem, ListItemViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ListItemViewHolder(ItemListMenuBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(viewHolder : ListItemViewHolder, position: Int) {
        val memeItem = getItem(position)
        viewHolder.bind(memeItem)
    }
}