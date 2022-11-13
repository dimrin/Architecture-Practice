package com.example.usecasespractice.domain.usecase

import com.example.usecasespractice.domain.models.SaveUsernameParam
import com.example.usecasespractice.domain.repository.UserRepository

class SaveUserNameUseCase(private val repository: UserRepository) {

    fun execute(param: SaveUsernameParam): Boolean {
        return repository.saveName(param)
    }

}