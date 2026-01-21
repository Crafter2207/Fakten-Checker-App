package com.fakten.checker.data.repository

import com.fakten.checker.data.mapper.toDomain
import com.fakten.checker.data.remote.MyBackendApi
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.repository.FactCheckRepository
import javax.inject.Inject

class FactCheckRepositoryImpl @Inject constructor(private val api: MyBackendApi) : FactCheckRepository {

    override suspend fun checkFact(url: String, provider: String): Fact {
        val response = api.checkFactWithAi(url, provider)
        return response.toDomain()
    }
}
