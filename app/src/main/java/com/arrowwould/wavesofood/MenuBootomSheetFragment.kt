package com.arrowwould.wavesofood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arrowwould.wavesofood.adaptar.MenuAdaptar
import com.arrowwould.wavesofood.databinding.FragmentMenuBootomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBootomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBootomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBootomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener {

            dismiss()

        }

        val menuFoodName = listOf("Burger", "sandwich", "momo", "item", "sandwich", "momo")
        val menuItemPtice = listOf("$100", "$200", "$300", "$400", "$100", "$100")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu1,
            R.drawable.menu2,
        )
        val adapter = MenuAdaptar(
            ArrayList(menuFoodName),
            ArrayList(menuItemPtice),
            ArrayList(menuImage)
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }


    companion object {


    }

}