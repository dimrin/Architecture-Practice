package com.example.usecasespractice.di

import com.example.usecasespractice.domain.usecase.GetUserNameUseCase
import com.example.usecasespractice.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory {
        GetUserNameUseCase(repository = get())
    }

    factory {
        SaveUserNameUseCase(repository = get())
    }
}