package com.example.btech.presentation.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.btech.databinding.ItemHorizontalBinding
import com.example.btech.presentation.ui.models.HorizontalModel

class HorizontalAdapter(
    private val onItemClick: OnItemClick
) :
    RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    private val data = mutableListOf<HorizontalModel>()

    fun setContent(model: List<HorizontalModel>) {
        data.clear()
        data.addAll(model)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
        holder.itemView.setOnClickListener {
            onItemClick.clickListener(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: ItemHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: HorizontalModel) {
            binding.imageViewPicture.load(model.image)
            binding.textViewCategoery.text = model.category
        }
    }

    interface OnItemClick {
        fun clickListener(model: HorizontalModel)
    }
}