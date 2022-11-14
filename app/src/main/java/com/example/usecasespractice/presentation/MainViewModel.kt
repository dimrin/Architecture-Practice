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

    private var stateLiveMutable = MutableLiveData<MainState>()
    val stateLive: LiveData<MainState> = stateLiveMutable

    init {
        Log.e("AAA", "VM created")
        stateLiveMutable.value = MainState(saveResult = false, firstName = "", lastName = "")
    }

    fun send(event: MainEvent) {

        when (event) {
            is SaveEvent -> {
                save(text = event.text)
            }
            is LoadEvent -> {
                load()
            }
        }

    }


    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    private fun save(text: String) {
        val params = SaveUsernameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = params)
        stateLiveMutable.value = MainState(
            saveResult = resultData,
            firstName = stateLiveMutable.value!!.firstName,
            lastName = stateLiveMutable.value!!.lastName
        )
    }

    private fun load() {
        val userName: Username = getUserNameUseCase.execute()
        stateLiveMutable.value = MainState(
            saveResult = stateLiveMutable.value!!.saveResult,
            firstName = userName.firstName,
            lastName = userName.lastName
        )
    }


}