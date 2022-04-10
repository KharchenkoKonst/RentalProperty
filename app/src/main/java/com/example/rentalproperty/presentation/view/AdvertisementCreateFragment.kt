package com.example.rentalproperty.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rentalproperty.R
import com.example.rentalproperty.databinding.AdvertisementCreateFragmentBinding

class AdvertisementCreateFragment : Fragment(R.layout.advertisement_create_fragment) {

    private var binding: AdvertisementCreateFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = AdvertisementCreateFragmentBinding.inflate(inflater).also {
        binding = it
    }.root

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}