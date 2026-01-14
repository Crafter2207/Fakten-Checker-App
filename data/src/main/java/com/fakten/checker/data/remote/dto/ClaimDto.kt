package com.fakten.checker.data.remote.dto

import com.fakten.checker.domain.model.ClaimStatus

/**
 * Data Transfer Object for a claim.
 */
data class ClaimDto(
    val text: String,
    val status: ClaimStatus,
    val rejectionReason: String? = null
)
