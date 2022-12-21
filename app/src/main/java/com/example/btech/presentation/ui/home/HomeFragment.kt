package com.example.btech.presentation.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.btech.R
import com.example.btech.databinding.FragmentHomeBinding
import com.example.btech.presentation.ui.home.adapters.HorizontalAdapter
import com.example.btech.presentation.ui.home.adapters.VerticalAdapter
import com.example.btech.presentation.ui.models.HorizontalModel
import com.example.btech.presentation.ui.models.VerticalModel

class HomeFragment : Fragment(), HorizontalAdapter.OnItemClick, VerticalAdapter.OnItemClicked {

    private lateinit var adapterHorizontal: HorizontalAdapter
    private lateinit var adapterVertical: VerticalAdapter
    private lateinit var viewModel: HomeViewModel
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewHorizontal.layoutManager = LinearLayoutManager(requireContext())
        adapterHorizontal = HorizontalAdapter(this)

        binding.recyclerViewVertical.layoutManager = LinearLayoutManager(requireContext())
        adapterVertical = VerticalAdapter(this)

        binding.recyclerViewHorizontal.adapter = adapterHorizontal
        binding.recyclerViewVertical.adapter = adapterVertical

        permissionCheck()
    }

    private fun permissionCheck() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val permissions = arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            ActivityCompat.requestPermissions(requireActivity(), permissions, 0)
        }
    }

    override fun clickListener(horizontalModel: HorizontalModel) {
        TODO("Not yet implemented")
    }

    override fun clickListener(verticalModel: VerticalModel) {
        TODO("Not yet implemented")
    }

}