package com.fakten.checker.domain.model

/**
 * Represents the status of a fact check.
 */
enum class FactStatus {
    /**
     * The fact has been confirmed by journalists.
     */
    CONFIRMED,

    /**
     * The fact is partially correct, but contains inaccuracies.
     */
    PARTIALLY_CORRECT,

    /**
     * There is not enough evidence to support or deny the fact.
     */
    UNPROVEN,

    /**
     * The fact has been proven false.
     */
    INCORRECT
}
