package com.example.test_third_month

import DifferentDirections
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_third_month.databinding.ItemStoresBinding

class ScrollViewAdapter(private val arrayList: ArrayList<DifferentDirections>) :
    RecyclerView.Adapter<ScrollViewAdapter.ScrollViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScrollViewHolder {
        return ScrollViewHolder(
            ItemStoresBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: ScrollViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    class ScrollViewHolder(private val binding: ItemStoresBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(differentDirections: DifferentDirections) {
            binding.itemSecondMainImage.setImageResource(differentDirections.image)
            binding.itemSecondMainText.text = differentDirections.text
        }
    }
}