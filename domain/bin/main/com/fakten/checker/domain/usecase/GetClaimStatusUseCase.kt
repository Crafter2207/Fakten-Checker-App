package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.Claim
import com.fakten.checker.domain.repository.FactRepository

class GetClaimStatusUseCase(private val factRepository: FactRepository) {

    suspend fun execute(claimId: String): Claim {
        return factRepository.getClaimStatus(claimId)
    }
}
