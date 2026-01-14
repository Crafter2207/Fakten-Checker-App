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
        // TODO: Implement API call for fact checking and cache result
        TODO("Not yet implemented")
    }

    override suspend fun checkFact(url: String): Fact {
        // TODO: Implement API call for fact checking and cache result
        TODO("Not yet implemented")
    }

    override suspend fun getProArguments(factId: String): List<Argument> {
        // TODO: Implement API call to get pro arguments
        TODO("Not yet implemented")
    }

    override suspend fun getContraArguments(factId: String): List<Argument> {
        // TODO: Implement API call to get contra arguments
        TODO("Not yet implemented")
    }

    override suspend fun submitClaim(claim: Claim) {
        // TODO: Implement API call to submit a claim
        TODO("Not yet implemented")
    }

    override suspend fun getClaimStatus(claimId: String): Claim {
        // TODO: Implement API call to get claim status
        TODO("Not yet implemented")
    }
}
