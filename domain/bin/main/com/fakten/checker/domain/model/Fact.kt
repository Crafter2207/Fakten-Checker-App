package com.fakten.checker.domain.model

import java.util.Date

/**
 * Represents a checked fact.
 *
 * @property statement The original statement that was checked.
 * @property status The result of the fact check.
 * @property sources A list of sources used for verification.
 * @property checkDate The date when the fact was last checked.
 */
data class Fact(
    val statement: String,
    val status: FactStatus,
    val sources: List<String>,
    val checkDate: Date
)
