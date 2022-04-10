package com.example.rentalproperty.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rentalproperty.R
import com.example.rentalproperty.app.appComponent
import com.example.rentalproperty.databinding.AdvertisementPreviewFragmentBinding
import com.example.rentalproperty.presentation.viewmodel.AdvertisementPreviewViewModel
import com.example.rentalproperty.presentation.viewmodel.factory.AdvertisementPreviewViewModelFactory

class AdvertisementPreviewFragment : Fragment() {

    private var binding: AdvertisementPreviewFragmentBinding? = null
    private val viewModel: AdvertisementPreviewViewModel by viewModels {
        AdvertisementPreviewViewModelFactory(
            requireActivity().appComponent.advertisementInteractor
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = AdvertisementPreviewFragmentBinding.inflate(inflater).also {
        binding = it
        (requireActivity() as MainActivity).run {
            hideLoader()
            showBottomNavigator()
        }
        subscribeOnVM()
        viewModel.loadAdvertisements()
    }.root

    private fun subscribeOnVM() {
        viewModel.advertisements.observe(viewLifecycleOwner) {
            // Отображение объявлений
        }
        viewModel.requireAuthorization.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.loginFragment)
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}