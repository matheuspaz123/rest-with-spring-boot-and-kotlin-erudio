package br.com.erudio.exceptions

import java.util.Date

data class ExceptionResponde(
    val timestamp: Date,
    val message: String?,
    val details: String
)
