package com.example.usecasespractice.di

import com.example.usecasespractice.data.repository.UserRepositoryImpl
import com.example.usecasespractice.data.storage.UserStorage
import com.example.usecasespractice.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecasespractice.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}