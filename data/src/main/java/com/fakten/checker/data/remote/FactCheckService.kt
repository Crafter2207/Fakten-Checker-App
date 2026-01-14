package com.fakten.checker.data.remote

import com.fakten.checker.data.remote.dto.FactDto
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit service interface for the fact-checking API.
 */
interface FactCheckService {

    /**
     * Submits a text for fact-checking.
     */
    @POST("check/text")
    suspend fun checkText(@Body text: String): FactDto

    /**
     * Submits a URL for fact-checking.
     */
    @POST("check/url")
    suspend fun checkUrl(@Body url: String): FactDto
}
