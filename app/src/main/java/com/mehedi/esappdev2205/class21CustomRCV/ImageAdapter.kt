package com.mehedi.esappdev2205.class21CustomRCV

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.mehedi.esappdev2205.databinding.ItemImageBinding

class ImageAdapter(var photoEvent: PhotoEvent) : ListAdapter<Image, ImageViewHolder>(comparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        getItem(position).let {
            holder.binding.imageNameTv.text = it.imageName

            holder.binding.imageView.load(it.imageUrl)

            holder.itemView.setOnClickListener { v ->


                photoEvent.PhotoClickListener(it)



            }


        }


    }


    companion object {

        var comparator = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem.imageUrl == newItem.imageUrl
            }

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {

                return oldItem == newItem

            }


        }


    }


}