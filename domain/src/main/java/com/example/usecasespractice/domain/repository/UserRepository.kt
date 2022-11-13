package com.example.usecasespractice.domain.repository

import com.example.usecasespractice.domain.models.SaveUsernameParam
import com.example.usecasespractice.domain.models.Username

interface UserRepository {

    fun saveName(saveParam: SaveUsernameParam): Boolean

    fun getName(): Username
}