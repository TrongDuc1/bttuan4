package com.example.btt2screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.btt2screen.databinding.ItemViewImageBinding
import com.example.btt2screen.adapter.OnImageItemListener

class ImageViewHolder(
    private val binding: ItemViewImageBinding ): RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentImageData: Image
    private lateinit var goto: OnImageItemListener
    init {
        binding.root.setOnClickListener{ goto.onClickItem(binding.root, currentImageData) }
        binding.root.setOnLongClickListener {
            goto.onLongClick(binding.root)
            true
        }
    }

    fun bindData(image: Image, goto: OnImageItemListener) {
        currentImageData = image
        this.goto = goto
        binding.restaurant = image
        Glide.with(binding.root.context).load(image.link).centerCrop().into(binding.ivAvatar)
        }
    companion object {
        fun from(parent: ViewGroup): ImageViewHolder {
            val binding: ItemViewImageBinding = ItemViewImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ImageViewHolder(binding)
        }

    }
    }
