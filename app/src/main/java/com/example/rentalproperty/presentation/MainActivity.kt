package com.example.rentalproperty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.rentalproperty.app.appComponent
import com.example.rentalproperty.databinding.ActivityMainBinding
import com.example.rentalproperty.presentation.viewmodel.MainActivityViewModel
import com.example.rentalproperty.presentation.viewmodel.factory.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val viewModel: MainActivityViewModel by viewModels {
        MainActivityViewModelFactory(appComponent.userInteractor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel.tryAuthenticate()

    }


    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}