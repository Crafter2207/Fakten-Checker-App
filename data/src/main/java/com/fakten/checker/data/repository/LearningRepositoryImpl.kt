package com.fakten.checker.data.repository

import com.fakten.checker.domain.model.LearningModule
import com.fakten.checker.domain.repository.LearningRepository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LearningRepositoryImpl @Inject constructor() : LearningRepository {

    // TODO: Inject remote and local data sources

    override suspend fun getLearningModules(): List<LearningModule> {
        return listOf(
            LearningModule("Fakt oder Behauptung?", "Lerne den Unterschied", com.fakten.checker.domain.model.LearningModuleType.FACT_VS_CLAIM),
            LearningModule("Quelle verstehen", "Bewerte die Glaubwürdigkeit einer Quelle", com.fakten.checker.domain.model.LearningModuleType.SOURCE_ANALYSIS)
        )
    }

    override suspend fun getLearningModuleProgress(moduleId: String): Int {
        return 0
    }

    override suspend fun updateLearningModuleProgress(moduleId: String, progress: Int) {
        // Placeholder
    }
}
