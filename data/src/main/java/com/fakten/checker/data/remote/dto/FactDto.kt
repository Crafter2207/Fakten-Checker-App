package com.fakten.checker.data.remote.dto

import com.fakten.checker.domain.model.FactStatus

/**
 * Data Transfer Object for a fact.
 */
data class FactDto(
    val statement: String,
    val status: FactStatus,
    val sources: List<String>,
    val checkDate: String
)
