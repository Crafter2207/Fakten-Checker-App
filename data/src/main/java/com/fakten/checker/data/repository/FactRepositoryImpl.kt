package com.fakten.checker.data.repository

import com.fakten.checker.data.local.dao.FactDao
import com.fakten.checker.data.remote.FactCheckService
import com.fakten.checker.domain.model.Argument
import com.fakten.checker.domain.model.Claim
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.model.FactStatus
import com.fakten.checker.domain.model.ClaimStatus
import com.fakten.checker.domain.repository.FactRepository
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FactRepositoryImpl @Inject constructor(
    private val factCheckService: FactCheckService,
    private val factDao: FactDao
) : FactRepository {

    override suspend fun checkFactFromText(text: String): Fact {
        return Fact(
            statement = text,
            status = FactStatus.UNPROVEN,
            sources = emptyList(),
            checkDate = Date()
        )
    }

    override suspend fun checkFactFromUrl(url: String): Fact {
        return Fact(
            statement = "URL: $url",
            status = FactStatus.UNPROVEN,
            sources = listOf(url),
            checkDate = Date()
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
            text = "Placeholder Claim",
            status = ClaimStatus.IN_REVIEW,
            rejectionReason = null
        )
    }
}

