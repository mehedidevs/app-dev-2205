package com.mehedi.esappdev2205.class20_simple_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mehedi.esappdev2205.databinding.ItemNameBinding

class NameAdapter : ListAdapter<String, NameViewHolder>(comparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        return NameViewHolder(ItemNameBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {

        getItem(position).let {

            holder.binding.userName.text = it

        }


    }

    companion object {
        var comparator = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }


    }


}