package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.repository.JournalistRepository

class AskQuestionUseCase(private val journalistRepository: JournalistRepository) {

    suspend fun execute(question: String) {
        journalistRepository.askQuestion(question)
    }
}
