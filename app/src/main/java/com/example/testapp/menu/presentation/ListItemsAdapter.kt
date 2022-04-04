package com.example.testapp.menu.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.testapp.databinding.ItemListMenuBinding
import com.example.testapp.main.domain.models.CocktailList
import javax.inject.Inject

class ListItemsAdapter @Inject constructor(callback: ListItemDiffCallback)
    : androidx.recyclerview.widget.ListAdapter<CocktailList, ListItemViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ListItemViewHolder(ItemListMenuBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(viewHolder : ListItemViewHolder, position: Int) {
        val memeItem = getItem(position)
        viewHolder.bind(memeItem)
    }
}