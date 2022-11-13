package com.example.usecasespractice.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.usecasespractice.R
import com.example.usecasespractice.data.repository.UserRepositoryImpl
import com.example.usecasespractice.data.storage.UserStorage
import com.example.usecasespractice.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecasespractice.domain.models.SaveUsernameParam
import com.example.usecasespractice.domain.models.Username
import com.example.usecasespractice.domain.usecase.GetUserNameUseCase
import com.example.usecasespractice.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val repository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(context = applicationContext)
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            repository = repository
        )
    }
    private val saveUsernameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            repository = repository
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton  = findViewById<Button>(R.id.save_button)
        val receiveButton = findViewById<Button>(R.id.get_button)

        sendButton.setOnClickListener {
            val data = dataEditView.text.toString()
            val params = SaveUsernameParam(name = data)
            val result = saveUsernameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val userName: Username = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }

    }
}