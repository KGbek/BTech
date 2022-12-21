package com.example.btech.presentation.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.btech.databinding.ItemVerticalBinding
import com.example.btech.presentation.ui.models.HorizontalModel
import com.example.btech.presentation.ui.models.VerticalModel

class VerticalAdapter (
    private val onItemClicked: HorizontalAdapter.OnItemClick
): RecyclerView.Adapter<ViewHolder>() {

    private val data = mutableListOf<VerticalModel>()

    fun setContent(modelVertical: List<VerticalModel>) {
        data.clear()
        data.addAll(modelVertical)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.onBindVertical(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: ItemVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBindVertical(verticalModel: VerticalModel) {
            binding.imageView.load(verticalModel.image)
            binding.imageViewLike.load(verticalModel.like)
            binding.textViewCredit.text = verticalModel.credit
            binding.textViewModel.text = verticalModel.model
            binding.textViewCost.text = verticalModel.cost

        }
    }
    interface OnItemClicked {
        fun clickListener(model: VerticalModel)
    }
}