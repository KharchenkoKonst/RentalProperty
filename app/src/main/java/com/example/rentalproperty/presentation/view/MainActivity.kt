package com.example.rentalproperty.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rentalproperty.R
import com.example.rentalproperty.app.appComponent
import com.example.rentalproperty.databinding.ActivityMainBinding
import com.example.rentalproperty.presentation.viewmodel.MainActivityViewModel
import com.example.rentalproperty.presentation.viewmodel.factory.MainActivityViewModelFactory
import com.example.rentalproperty.utils.setVisibility

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    private var binding: ActivityMainBinding? = null
    private val viewModel: MainActivityViewModel by viewModels {
        MainActivityViewModelFactory(
            appComponent.userInteractor,
            appComponent.advertisementInteractor
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        navController = findNavController(R.id.navFragment).also {
            binding?.bottomNavigateView?.setupWithNavController(it)
        }
        showLoader()
        hideBottomNavigator()
    }

    fun showBottomNavigator() {
        binding?.bottomNavigateView?.setVisibility(true)
    }

    fun hideBottomNavigator() {
        binding?.bottomNavigateView?.setVisibility(false)
    }

    fun showLoader() {
        binding?.loaderScreen?.root?.setVisibility(true)
    }

    fun hideLoader() {
        binding?.loaderScreen?.root?.setVisibility(false)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}