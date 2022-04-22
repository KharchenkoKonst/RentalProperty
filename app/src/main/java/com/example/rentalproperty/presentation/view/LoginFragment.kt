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
import com.example.rentalproperty.databinding.LoginFragmentBinding
import com.example.rentalproperty.presentation.viewmodel.LoginViewModel
import com.example.rentalproperty.presentation.viewmodel.factory.LoginViewModelFactory

class LoginFragment : Fragment() {

    private var binding: LoginFragmentBinding? = null
    private val viewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(
            requireActivity().appComponent.userInteractor
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = LoginFragmentBinding.inflate(inflater).also {
        binding = it
        (requireActivity() as MainActivity).run {
            hideLoader()
            hideBottomNavigator()
        }
        setButtonsListeners()
        subscribeOnVM()
    }.root

    private fun setButtonsListeners() {
        binding?.let { binding ->
            binding.loginButton.setOnClickListener {
                viewModel.login(
                    binding.usernameInput.text.toString(),
                    binding.passwordInput.text.toString()
                )
            }
            binding.registrationButton.setOnClickListener {
                viewModel.register(
                    binding.usernameInput.text.toString(),
                    binding.passwordInput.text.toString()
                )
            }
        }
    }

    private fun subscribeOnVM() {
        viewModel.loadAdvertisement.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_loginFragment_to_advertisementPreviewFragment)
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}