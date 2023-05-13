package com.example.test_third_month

import DifferentDirections
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test_third_month.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var arrayListDD = ArrayList<DifferentDirections>()
    private var mainArrayList = ArrayList<Product>()
    private lateinit var adapter1: ScrollViewAdapter
    private lateinit var adapter2: MainAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillList()
        fillListSecond()
    }

    private fun fillListSecond() {
        mainArrayList.add(
            Product(
                R.drawable.item_one_main_image,
                "Burger Craze",
                "OPEN",
                "5.0",
                "American",
                "Burger",
                "FREE",
                "32",
                "10$"
            )
        )
        mainArrayList.add(
            Product(
                R.drawable.pizza,
                "Burger Craze",
                "OPEN",
                "5.0",
                "American",
                "Burger",
                "FREE",
                "32",
                "10$"
            )
        )
        mainArrayList.add(
            Product(
                R.drawable.item_one_main_image,
                "Burger Craze",
                "OPEN",
                "5.0",
                "American",
                "Burger",
                "FREE",
                " ( 32 ) ",
                "10$"
            )
        )
        adapter2 = MainAdapter(mainArrayList, this::onProductClick)
        binding.recyclerViewMain.adapter = adapter2
    }

    private fun onProductClick(position: Int) {
        val bundle = Bundle()
        val fragment = DetailFragment()
        bundle.putSerializable("product", mainArrayList[position])
        fragment.arguments = bundle
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment2, bundle)
    }


    fun fillList() {
        arrayListDD.add(DifferentDirections(R.drawable.burger, "Takeaways"))
        arrayListDD.add(DifferentDirections(R.drawable.burger, "Grocery"))
        arrayListDD.add(DifferentDirections(R.drawable.burger, "Takeaways"))
        arrayListDD.add(DifferentDirections(R.drawable.burger, "Takeaways"))
        adapter1 = ScrollViewAdapter(arrayListDD)
        binding.recyclerView.adapter = adapter1
    }
}