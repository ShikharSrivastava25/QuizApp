package com.example.quizapp.presentation.nav_graph

import androidx.compose.ui.res.colorResource

const val ARG_KEY_QUIZ_NUMBER = "ak_quiz_number"
const val ARG_KEY_QUIZ_CATEGORY = "ak_quiz_category"
const val ARG_KEY_QUIZ_DIFFICULTY = "ak_quiz_difficulty"
const val ARG_KEY_QUIZ_TYPE = "ak_quiz_type"
const val NOQ_KEY = "noq_key"
const val CORRECT_ANS_KEY = "correct_ans_key"


sealed class Routes(val route : String) {
    object HomeScreen : Routes(route = "home_screen")

    // think of the below as a 'Bundle', when we move from home screen to quiz screen all of the info has to be passed
    object QuizScreen : Routes(route = "quiz_screen/{$ARG_KEY_QUIZ_NUMBER}/{$ARG_KEY_QUIZ_CATEGORY}/{$ARG_KEY_QUIZ_DIFFICULTY}/{$ARG_KEY_QUIZ_TYPE}")

    fun passQuizParams(numOfQuizzes : Int, cateogry : String, difficulty : String, type : String) : String {

        return "quiz_screen/{$ARG_KEY_QUIZ_NUMBER}/{$ARG_KEY_QUIZ_CATEGORY}/{$ARG_KEY_QUIZ_DIFFICULTY}/{$ARG_KEY_QUIZ_TYPE}"
            .replace(
                oldValue = "{$ARG_KEY_QUIZ_NUMBER}",
                newValue = numOfQuizzes.toString()
            )
            .replace(
                oldValue = "{$ARG_KEY_QUIZ_CATEGORY}",
                newValue = cateogry.toString()
            )
            .replace(
                oldValue = "{$ARG_KEY_QUIZ_DIFFICULTY}",
                newValue = difficulty.toString()
            )
            .replace(
                oldValue = "{$ARG_KEY_QUIZ_TYPE}",
                newValue = type.toString()
            )
    }

    object ScoreScreen : Routes(route = "score_screen/{$NOQ_KEY}/{$CORRECT_ANS_KEY}") {
        fun passNumOfQuestionsAndCorrectAns(questions : Int, correctAnswers : Int) : String {
            return "score_screen/{$NOQ_KEY}/{$CORRECT_ANS_KEY}"
                .replace("{$NOQ_KEY}", questions.toString())
                .replace("{$CORRECT_ANS_KEY}", correctAnswers.toString())
        }
    }
}