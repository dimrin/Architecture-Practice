package com.example.usecasespractice.di

import com.example.usecasespractice.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(getUserNameUseCase = get(), saveUserNameUseCase = get())
    }
}