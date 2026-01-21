package com.fakten.checker.data.remote

import com.fakten.checker.data.remote.dto.BackendResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MyBackendApi {
    @GET("analyze")
    suspend fun checkFactWithAi(
        @Query("url") targetUrl: String
    ): BackendResponse
}
