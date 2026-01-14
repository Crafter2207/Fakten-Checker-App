package com.fakten.checker.domain.model

/**
 * Represents a single gamified learning module.
 *
 * @property title The title of the learning module.
 * @property description A short description of the learning module's content.
 * @property type The type of the learning module.
 */
data class LearningModule(
    val title: String,
    val description: String,
    val type: LearningModuleType
)
