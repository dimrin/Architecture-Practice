package com.example.usecasespractice.domain.usecase

import com.example.usecasespractice.domain.models.Username
import com.example.usecasespractice.domain.repository.UserRepository

class GetUserNameUseCase(private val repository: UserRepository) {

    fun execute(): Username {
        return repository.getName()
    }
}