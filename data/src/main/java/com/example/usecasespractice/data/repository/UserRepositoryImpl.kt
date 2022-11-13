package com.example.usecasespractice.data.repository

import com.example.usecasespractice.data.storage.models.User
import com.example.usecasespractice.data.storage.UserStorage
import com.example.usecasespractice.domain.models.SaveUsernameParam
import com.example.usecasespractice.domain.models.Username
import com.example.usecasespractice.domain.repository.UserRepository



class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {



    override fun saveName(saveParam: SaveUsernameParam): Boolean{

        val user = mapToStorage(saveParam)

        return userStorage.save(user)
    }

    override fun  getName(): Username {
        val user = userStorage.get()

        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): Username {
        return Username(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUsernameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }
}