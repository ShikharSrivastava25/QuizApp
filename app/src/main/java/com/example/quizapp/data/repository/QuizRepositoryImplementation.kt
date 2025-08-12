package com.example.quizapp.data.repository

import com.example.quizapp.data.remote.QuizApi
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.domain.repository.QuizRepository

class QuizRepositoryImplementation(
    private val quizApi : QuizApi
) : QuizRepository {
    override suspend fun getQuizzes(
        amount: Int ,
        category: Int ,
        difficulty: String ,
        type: String
    ): List<Quiz> {
        return quizApi.getQuizzes(amount, category, difficulty, type).results
    }
}