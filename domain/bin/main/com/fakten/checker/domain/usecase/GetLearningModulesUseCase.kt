package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.LearningModule
import com.fakten.checker.domain.repository.LearningRepository

class GetLearningModulesUseCase(private val learningRepository: LearningRepository) {

    suspend fun execute(): List<LearningModule> {
        return learningRepository.getLearningModules()
    }
}
