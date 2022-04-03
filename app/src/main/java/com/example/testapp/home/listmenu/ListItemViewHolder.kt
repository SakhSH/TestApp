package com.example.testapp.home.listmenu

import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.ItemListMenuBinding

class ListItemViewHolder(private val binding: ItemListMenuBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(listItem: BannerItem) {

        binding.ivLogo.setImageResource(R.drawable.ic_baseline_local_pizza_24)
        binding.tvTitleText.text = listItem.title
        binding.tvDescription.text = listItem.description
    }
}