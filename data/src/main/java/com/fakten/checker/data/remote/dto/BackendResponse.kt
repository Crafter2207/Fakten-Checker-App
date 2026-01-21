package com.fakten.checker.data.remote.dto

data class BackendResponse(
    val analysis: String,
    val status: String,
    val message: String?
)
