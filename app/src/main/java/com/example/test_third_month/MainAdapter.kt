package com.example.test_third_month

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_third_month.databinding.ItemCafeBinding

class MainAdapter(
    private val mainArrayList: ArrayList<Product>,
    val onItemClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemCafeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = mainArrayList.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(mainArrayList[position])
    }

    inner class MainViewHolder(private val binding: ItemCafeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(product: Product) {
            binding.itemOneMainImage.setImageResource(product.image)
            binding.namePlace.text = product.nameProduct
            binding.isOpen.text = product.isOpen
            binding.rate.text = product.rate
            binding.rateInt.text = product.rateInt
            binding.description.text = product.description
            binding.product.text = product.product
            binding.deliveryPrice.text = product.deliveryPrice
            binding.minimumPrice.text = product.minimumPrice

            itemView.setOnClickListener {
                onItemClick(position)
            }
        }

    }
}