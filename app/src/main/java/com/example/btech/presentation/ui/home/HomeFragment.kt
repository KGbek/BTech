package com.example.btech.presentation.ui.home

import android.os.Bundle
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.btech.R
import com.example.btech.databinding.FragmentHomeBinding
import com.example.btech.presentation.ui.home.adapters.HorizontalAdapter
import com.example.btech.presentation.ui.models.HorizontalModel

class HomeFragment : Fragment(), HorizontalAdapter.OnItemClick {

    private lateinit var adapter: HorizontalAdapter
    private lateinit var viewModel: HomeViewModel
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewHorizontal.layoutManager = LinearLayoutManager(requireContext())
        adapter = HorizontalAdapter(this)

        binding.recyclerViewHorizontal.adapter = adapter
    }

    override fun clickListener(model: HorizontalModel) {
        TODO("Not yet implemented")
    }

}