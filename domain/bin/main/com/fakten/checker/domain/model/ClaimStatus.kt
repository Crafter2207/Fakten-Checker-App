package com.fakten.checker.domain.model

/**
 * Represents the status of a user-submitted claim.
 */
enum class ClaimStatus {
    /**
     * The claim is currently being reviewed by journalists.
     */
    IN_REVIEW,

    /**
     * The claim has been checked and a fact has been created.
     */
    CHECKED,

    /**
     * The claim has been rejected.
     */
    REJECTED
}
