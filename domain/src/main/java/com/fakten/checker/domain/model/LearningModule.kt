package com.fakten.checker.domain.model

enum class LearningModuleType {
    QUIZ,
    VIDEO,
    TEXT,
    FACT_VS_CLAIM,    // Hinzugefügt für das Repository
    SOURCE_ANALYSIS   // Hinzugefügt für das Repository
}

data class LearningModule(
    val title: String,
    val description: String,
    val type: LearningModuleType
)