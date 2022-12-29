package com.example.btech.presentation.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.btech.databinding.ItemCartHorizontalBinding
import com.example.btech.presentation.ui.models.HorizontalCartModel

class CartAdapter() :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private val horizontalCartModel = mutableListOf<HorizontalCartModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCartHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(horizontalCartModel[position])
    }

    override fun getItemCount(): Int {
        return horizontalCartModel.size
    }

    class ViewHolder(private val binding: ItemCartHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(horizontalCartModel: HorizontalCartModel) {
            binding.imageViewAdCard1.load(horizontalCartModel.cartBackground1)
            binding.imageViewAdCard2.load(horizontalCartModel.cartBackground2)
            binding.imageViewCart.load(horizontalCartModel.cartImage)
            binding.textViewAd.text = horizontalCartModel.adText
        }
    }
}