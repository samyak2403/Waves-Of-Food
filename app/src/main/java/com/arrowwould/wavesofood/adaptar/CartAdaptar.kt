package com.arrowwould.wavesofood.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arrowwould.wavesofood.databinding.CartItemBinding

class CartAdaptar(
    private val CartItems: MutableList<String>,
    private val CartItemPrice: MutableList<String>,
    private val CartImage: MutableList<Int>
) : RecyclerView.Adapter<CartAdaptar.CartViewHolder>() {
    private val itemQuentities = IntArray(CartItems.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = CartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuentities[position]
                cartFoodName.text = CartItems[position]
                cartItemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemquantity.text = quantity.toString()

                minusbutton.setOnClickListener {
                    deceaseQuantity(position)
                }
                plusebutton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION)
                        deleteItem(itemPosition)
                }
            }

        }
        private fun increaseQuantity(position: Int) {
            if (itemQuentities[position]<10) {
                itemQuentities[position]++
                binding.cartItemquantity.text = itemQuentities[position].toString()
            }
        }
        private fun deceaseQuantity(position: Int) {
            if (itemQuentities[position] >1) {
                itemQuentities[position]--
                binding.cartItemquantity.text = itemQuentities[position].toString()
            }

        }


        private fun deleteItem(position: Int) {
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position, CartItems.size)
        }


    }
}
