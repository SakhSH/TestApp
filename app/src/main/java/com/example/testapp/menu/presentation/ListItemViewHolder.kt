package com.example.testapp.menu.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.databinding.ItemListMenuBinding
import com.example.testapp.main.domain.models.CocktailList

class ListItemViewHolder(private val binding: ItemListMenuBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(listItem: CocktailList) {

        Glide.with(itemView.context)
            .load(listItem.image)
            .into(binding.ivLogo)
        binding.tvTitleText.text = listItem.topText
        binding.tvDescription.text = listItem.bottomText
    }
}