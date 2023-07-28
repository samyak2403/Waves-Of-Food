package com.arrowwould.wavesofood.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arrowwould.wavesofood.R
import com.arrowwould.wavesofood.adaptar.CartAdaptar
import com.arrowwould.wavesofood.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)


        val cartFoodName = listOf("Burger","sandwich", "momo","item","sandwich","momo")
        val cartItemPtice = listOf("$100","$200","$300","$400","$100","$100")
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu1,
            R.drawable.menu2,
        )
        val adapter = CartAdaptar(ArrayList(cartFoodName),ArrayList(cartItemPtice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter =adapter
        return binding.root
    }


}