package com.arrowwould.wavesofood.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arrowwould.wavesofood.databinding.PopulerItemBinding

class PopularAdaptar (private val items:List<String>, private val price:List<String>, private val image:List<Int>) : RecyclerView.Adapter<PopularAdaptar.PouplerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplerViewHolder {
        return PouplerViewHolder(PopulerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PouplerViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    class PouplerViewHolder(private val binding: PopulerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.imageView6
        fun bind(item: String,price:String, images: Int) {
            binding.FoodNamePopuler.text = item
            binding.PricePopuar.text = price
            imagesView.setImageResource(images)

        }

    }

}