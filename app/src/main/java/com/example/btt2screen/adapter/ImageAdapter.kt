package com.example.btt2screen.adapter
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.btt2screen.Image
import com.example.btt2screen.ImageViewHolder


interface OnImageItemListener {
    fun onClickItem(item: View, restaurant: Image)

    fun onLongClick(item: View)
}

class ImageAdapter( private val goto: OnImageItemListener) :
    ListAdapter<Image, ImageViewHolder>
        (ImageDiffUtil()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        return ImageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val idol = getItem(position)
        holder.bindData(idol, goto)
    }


    class ImageDiffUtil : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Image,
            newItem: Image
        ): Boolean {
            return oldItem.name == newItem.name && oldItem.link == newItem.link && oldItem.address == newItem.address
        }
    }
    class ImageDiffUtilCallback(
        private val oldList: MutableList<Image>,
        private val newList: MutableList<Image>): DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].link == newList[newItemPosition].link &&
                    oldList[oldItemPosition].name == newList[newItemPosition].name &&
                    oldList[oldItemPosition].address == newList[newItemPosition].address
        }
    }}