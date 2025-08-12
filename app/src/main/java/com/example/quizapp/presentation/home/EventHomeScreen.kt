package com.example.quizapp.presentation.home

// When we know how many objects are to be created from a class, use sealed class
sealed class EventHomeScreen {

    data class SetNumberOfQuizzes(val numberOfQuizzes : Int) : EventHomeScreen()
    data class SetQuizCategory(val category : String) : EventHomeScreen()
    data class SetQuizDifficulty(val difficulty : String) : EventHomeScreen()
    data class SetQuizType(val type : String) : EventHomeScreen()
}