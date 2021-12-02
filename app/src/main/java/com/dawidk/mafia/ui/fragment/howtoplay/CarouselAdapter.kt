package com.dawidk.mafia.ui.fragment.howtoplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dawidk.mafia.databinding.ItemContainerHowToPlayBinding
import com.dawidk.mafia.model.HowToPlayItem
import org.koin.core.component.KoinComponent

class CarouselAdapter :
    ListAdapter<HowToPlayItem, CarouselAdapter.HowToPlayViewHolder>(
        ItemDiffCallback()
    ), KoinComponent {

    private class ItemDiffCallback : DiffUtil.ItemCallback<HowToPlayItem>() {

        override fun areItemsTheSame(oldItem: HowToPlayItem, newItem: HowToPlayItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: HowToPlayItem, newItem: HowToPlayItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItem(position: Int): HowToPlayItem {
        return super.getItem(position % currentList.size)
    }

    fun getOriginalItemCount(): Int {
        return currentList.size
    }

    override fun getItemCount(): Int {
        return currentList.size * 3
    }

    inner class HowToPlayViewHolder(private val binding: ItemContainerHowToPlayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun applyItem(howToPlayItem: HowToPlayItem) {
            binding.apply {
                titleTv.text = howToPlayItem.title
                descriptionTv.text = howToPlayItem.description
                instructionIv.setImageResource(howToPlayItem.imageId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HowToPlayViewHolder {
        return HowToPlayViewHolder(
            ItemContainerHowToPlayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HowToPlayViewHolder, position: Int) {
        getItem(position).let {
            holder.applyItem(it)
        }
    }
}