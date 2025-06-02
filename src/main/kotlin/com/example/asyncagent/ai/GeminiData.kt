package com.example.asyncagent.ai

// Placeholder data classes for Gemini Service
data class CodePrompt(val text: String, val context: Map<String, String>? = null)

data class CodeResponse(
    val code: String?,
    val success: Boolean,
    val error: String? = null,
    // Adding fields from the more detailed GeminiService in the issue for completeness
    val explanation: String? = null,
    val tokensUsed: Int = 0,
    val retryAfter: Long? = null
)
