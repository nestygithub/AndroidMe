package com.chiki.androidme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chiki.androidme.data.BodyPart
import com.chiki.androidme.databinding.GridPhotoBinding

class BodyPartAdapter(private val onItemClicked:(Int)->Unit): ListAdapter<BodyPart, BodyPartAdapter.BodyPartViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyPartViewHolder {
        return BodyPartViewHolder.from(this, parent, onItemClicked)
    }
    override fun onBindViewHolder(holder: BodyPartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BodyPartViewHolder private constructor(private val binding: GridPhotoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(bodyPart: BodyPart) {
            binding.bodyPart = bodyPart
            binding.executePendingBindings()
        }
        companion object{
            fun from(photoAdapter: BodyPartAdapter, parent: ViewGroup, onItemClicked: (Int) -> Unit):BodyPartViewHolder {
                val viewHolder = BodyPartViewHolder(GridPhotoBinding.inflate(LayoutInflater.from(parent.context), parent,false))
                viewHolder.itemView.setOnClickListener {
                    val position = viewHolder.adapterPosition
                    onItemClicked(position)
                }
                return viewHolder
            }
        }
    }

    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<BodyPart>() {
            override fun areItemsTheSame(oldItem: BodyPart, newItem: BodyPart): Boolean {
                return oldItem.imageId == newItem.imageId
            }
            override fun areContentsTheSame(oldItem: BodyPart, newItem: BodyPart): Boolean {
                return oldItem == newItem
            }
        }
    }
}

