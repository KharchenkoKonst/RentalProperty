package com.example.rentalproperty.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentalproperty.domain.interactor.UserInteractor
import com.example.rentalproperty.presentation.viewmodel.StarterViewModel

@Suppress("UNCHECKED_CAST")
class StarterViewModelFactory(
    private val userInteractor: UserInteractor
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        StarterViewModel(userInteractor) as T
}
