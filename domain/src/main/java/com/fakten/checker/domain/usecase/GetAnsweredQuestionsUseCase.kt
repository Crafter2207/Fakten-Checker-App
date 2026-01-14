package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.Question
import com.fakten.checker.domain.repository.JournalistRepository

class GetAnsweredQuestionsUseCase(private val journalistRepository: JournalistRepository) {

    suspend fun execute(): List<Question> {
        return journalistRepository.getAnsweredQuestions()
    }
}
