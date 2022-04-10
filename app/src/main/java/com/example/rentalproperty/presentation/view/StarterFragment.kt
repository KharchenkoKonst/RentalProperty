package com.example.rentalproperty.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rentalproperty.R
import com.example.rentalproperty.app.appComponent
import com.example.rentalproperty.databinding.StarterFragmentBinding
import com.example.rentalproperty.presentation.viewmodel.StarterViewModel
import com.example.rentalproperty.presentation.viewmodel.factory.StarterViewModelFactory

class StarterFragment : Fragment() {

    private var binding: StarterFragmentBinding? = null
    private val viewModel: StarterViewModel by viewModels {
        StarterViewModelFactory(
            requireActivity().appComponent.userInteractor
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = StarterFragmentBinding.inflate(inflater).also {
        binding = it
        subscribeOnVM()
    }.root

    private fun subscribeOnVM() {
        viewModel.requireLogin.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_starterFragment_to_loginFragment)
        }
        viewModel.loadAdvertisements.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.advertisementPreviewFragment)

        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}