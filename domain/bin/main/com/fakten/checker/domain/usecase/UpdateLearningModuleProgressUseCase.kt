package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.repository.LearningRepository

class UpdateLearningModuleProgressUseCase(private val learningRepository: LearningRepository) {

    suspend fun execute(moduleId: String, progress: Int) {
        learningRepository.updateLearningModuleProgress(moduleId, progress)
    }
}
