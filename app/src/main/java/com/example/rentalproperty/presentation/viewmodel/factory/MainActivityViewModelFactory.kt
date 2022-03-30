package com.example.rentalproperty.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentalproperty.domain.interactor.UserInteractor
import com.example.rentalproperty.presentation.viewmodel.MainActivityViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory @Inject constructor(private val userInteractor: UserInteractor) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainActivityViewModel(userInteractor) as T
}