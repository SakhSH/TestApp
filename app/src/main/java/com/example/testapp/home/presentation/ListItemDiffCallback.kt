package com.example.testapp.home.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.testapp.main.domain.models.CocktailList
import javax.inject.Inject

class ListItemDiffCallback @Inject constructor() : DiffUtil.ItemCallback<CocktailList>() {
    override fun areItemsTheSame(oldItem: CocktailList, newItem: CocktailList): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CocktailList, newItem: CocktailList): Boolean {
        return oldItem == newItem
    }


}