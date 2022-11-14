package com.example.usecasespractice.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usecasespractice.domain.models.SaveUsernameParam
import com.example.usecasespractice.domain.models.Username
import com.example.usecasespractice.domain.usecase.GetUserNameUseCase
import com.example.usecasespractice.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "VM created")
    }


    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUsernameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value =  "Save result = $resultData"
    }

    fun load() {
        val userName: Username = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }


}