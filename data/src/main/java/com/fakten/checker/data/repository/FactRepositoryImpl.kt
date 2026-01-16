package com.fakten.checker.data.repository

import com.fakten.checker.data.local.dao.FactDao
import com.fakten.checker.data.remote.FactCheckService
import com.fakten.checker.domain.model.Argument
import com.fakten.checker.domain.model.Claim
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.repository.FactRepository
import javax.inject.Inject

class FactRepositoryImpl @Inject constructor(
    private val factCheckService: FactCheckService,
    private val factDao: FactDao
) : FactRepository {

    override suspend fun checkFact(text: String): Fact {
        return Fact(
            id = "placeholder",
            text = text,
            status = com.fakten.checker.domain.model.FactStatus.PENDING,
            source = "Unknown",
            confidence = 0.0f,
            explanation = "Analyse läuft..."
        )
    }

    override suspend fun checkFact(url: String): Fact {
        return Fact(
            id = "placeholder_url",
            text = "URL: $url",
            status = com.fakten.checker.domain.model.FactStatus.PENDING,
            source = url,
            confidence = 0.0f,
            explanation = "URL wird analysiert..."
        )
    }

    override suspend fun getProArguments(factId: String): List<Argument> {
        return emptyList()
    }

    override suspend fun getContraArguments(factId: String): List<Argument> {
        return emptyList()
    }

    override suspend fun submitClaim(claim: Claim) {
        // Placeholder for submission
    }

    override suspend fun getClaimStatus(claimId: String): Claim {
        return Claim(
            id = claimId,
            text = "Placeholder Claim",
            status = com.fakten.checker.domain.model.ClaimStatus.SUBMITTED,
            submittedAt = java.util.Date()
        )
    }
}
