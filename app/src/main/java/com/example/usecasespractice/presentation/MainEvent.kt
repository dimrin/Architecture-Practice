package com.example.usecasespractice.presentation

interface MainEvent

class SaveEvent(val text: String): MainEvent

class LoadEvent: MainEvent