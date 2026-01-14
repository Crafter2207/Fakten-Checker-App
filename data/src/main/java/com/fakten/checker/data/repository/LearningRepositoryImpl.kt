package com.fakten.checker.data.repository

import com.fakten.checker.domain.model.LearningModule
import com.fakten.checker.domain.repository.LearningRepository

class LearningRepositoryImpl : LearningRepository {

    // TODO: Inject remote and local data sources

    override suspend fun getLearningModules(): List<LearningModule> {
        // TODO: Implement API or local call to get learning modules
        TODO("Not yet implemented")
    }

    override suspend fun getLearningModuleProgress(moduleId: String): Int {
        // TODO: Implement local call to get module progress
        TODO("Not yet implemented")
    }

    override suspend fun updateLearningModuleProgress(moduleId: String, progress: Int) {
        // TODO: Implement local call to update module progress
        TODO("Not yet implemented")
    }
}
