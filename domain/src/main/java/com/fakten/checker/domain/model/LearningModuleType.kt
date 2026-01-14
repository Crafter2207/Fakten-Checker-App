package com.fakten.checker.domain.model

/**
 * Represents the type of a gamified learning module.
 */
enum class LearningModuleType {
    /**
     * A module to learn the difference between a fact and a claim.
     */
    FACT_VS_CLAIM,

    /**
     * A module to learn how to understand and evaluate sources.
     */
    SOURCE_ANALYSIS,

    /**
     * A module to learn the difference between an argument and an opinion.
     */
    ARGUMENT_VS_OPINION
}
