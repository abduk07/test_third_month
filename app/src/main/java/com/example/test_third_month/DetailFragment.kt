package com.example.test_third_month

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test_third_month.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data()
    }

    private fun data() {
        val product: Product = arguments?.getSerializable("product") as Product
        binding.itemSecondMainImage.setImageResource(product.image)
        binding.textViewTitleStoresStuffItem.text = product.nameProduct
        binding.textViewStoreOpenInfo.text = product.isOpen
        binding.rate.text = product.rate
        binding.rateInt.text = product.rateInt
        binding.description.text = product.description
        binding.product.text = product.product
        binding.deliveryPrice.text = product.deliveryPrice
        binding.minimumPrice.text = product.minimumPrice
    }
}