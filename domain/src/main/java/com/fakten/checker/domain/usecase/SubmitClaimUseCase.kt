package com.fakten.checker.domain.usecase

import com.fakten.checker.domain.model.Claim
import com.fakten.checker.domain.repository.FactRepository

class SubmitClaimUseCase(private val factRepository: FactRepository) {

    suspend fun execute(claim: Claim) {
        factRepository.submitClaim(claim)
    }
}
