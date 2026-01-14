package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.repository.LearningRepository

class GetLearningModuleProgressUseCase(private val learningRepository: LearningRepository) {

    suspend fun execute(moduleId: String): Int {
        return learningRepository.getLearningModuleProgress(moduleId)
    }
}
