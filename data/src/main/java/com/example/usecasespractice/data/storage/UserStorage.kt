package com.example.usecasespractice.data.storage

import com.example.usecasespractice.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}