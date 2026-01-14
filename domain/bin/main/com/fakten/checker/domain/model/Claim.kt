package com.fakten.checker.domain.model

/**
 * Represents a claim submitted by a user for fact-checking.
 *
 * @property text The text of the claim.
 * @property status The current status of the claim in the review process.
 * @property rejectionReason An optional reason for rejection, if applicable.
 */
data class Claim(
    val text: String,
    val status: ClaimStatus,
    val rejectionReason: String? = null
)
