package com.fakten.checker.domain.repository

import com.fakten.checker.domain.model.LearningModule

/**
 * Interface for the repository that handles learning modules.
 */
interface LearningRepository {

    /**
     * Retrieves all available learning modules.
     *
     * @return A list of [LearningModule]s.
     */
    suspend fun getLearningModules(): List<LearningModule>

    /**
     * Retrieves the user's progress for a specific learning module.
     *
     * @param moduleId The ID of the learning module.
     * @return A value indicating the user's progress (e.g., a percentage or a boolean for completion).
     */
    suspend fun getLearningModuleProgress(moduleId: String): Int

    /**
     * Updates the user's progress for a specific learning module.
     *
     * @param moduleId The ID of the learning module.
     * @param progress The new progress value.
     */
    suspend fun updateLearningModuleProgress(moduleId: String, progress: Int)
}
