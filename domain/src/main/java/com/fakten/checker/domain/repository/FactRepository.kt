package com.fakten.checker.domain.repository

import com.fakten.checker.domain.model.Argument
import com.fakten.checker.domain.model.Claim
import com.fakten.checker.domain.model.Fact

/**
 * Interface for the repository that handles fact-checking and claims.
 */
interface FactRepository {

    /**
     * Submits a text for fact-checking.
     *
     * @param text The text to be checked.
     * @return The checked [Fact].
     */
    suspend fun checkFact(text: String): Fact

    /**
     * Submits a URL for fact-checking.
     *
     * @param url The URL to be checked.
     * @return The checked [Fact].
     */
    suspend fun checkFact(url: String): Fact

    /**
     * Retrieves the pro arguments for a given fact ID.
     *
     * @param factId The ID of the fact.
     * @return A list of pro [Argument]s.
     */
    suspend fun getProArguments(factId: String): List<Argument>

    /**
     * Retrieves the contra arguments for a given fact ID.
     *
     * @param factId The ID of the fact.
     * @return A list of contra [Argument]s.
     */
    suspend fun getContraArguments(factId: String): List<Argument>

    /**
     * Submits a claim for review.
     *
     * @param claim The [Claim] to be submitted.
     */
    suspend fun submitClaim(claim: Claim)

    /**
     * Retrieves the status of a submitted claim.
     *
     * @param claimId The ID of the claim.
     * @return The [Claim] with its current status.
     */
    suspend fun getClaimStatus(claimId: String): Claim
}
