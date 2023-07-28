package com.arrowwould.wavesofood.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arrowwould.wavesofood.R
import com.arrowwould.wavesofood.adaptar.MenuAdaptar
import com.arrowwould.wavesofood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var adaptar : MenuAdaptar

    private val orignalMenuFoodName =
        listOf("Burger", "sandwich", "momo", "item", "sandwich", "momo")

    private val orignalMenuPrice = listOf("$100", "$200", "$300", "$400", "$100", "$100")

    private val orignalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu1,
        R.drawable.menu2,)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)

        adaptar = MenuAdaptar(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage)

        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.menuRecyclerView.adapter = adaptar

        // setup for serch view

        setupSearchView()

        //show all menusItems
        showAllMenu()


        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(orignalMenuFoodName)
        filteredMenuItemPrice.addAll(orignalMenuPrice)
        filteredMenuImage.addAll(orignalMenuImage)

        adaptar.notifyDataSetChanged()

    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {

        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        orignalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query,ignoreCase = true)){

                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(orignalMenuPrice[index])
                filteredMenuImage.add(orignalMenuImage[index])

            }
        }

        adaptar.notifyDataSetChanged()

    }


}