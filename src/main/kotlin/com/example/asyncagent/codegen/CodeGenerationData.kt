package com.example.asyncagent.codegen

// Placeholder data classes for Code Generation
data class GeneratedCode(
    val filePath: String,
    val code: String,
    val imports: List<String> = emptyList(),
    val isValid: Boolean = true // Simplified
)

interface ComponentSpec {
    val name: String
}

data class ActivitySpec(override val name: String, val layout: String, val viewModelName: String? = null) : ComponentSpec
data class FragmentSpec(override val name: String, val layout: String, val viewModelName: String? = null) : ComponentSpec
data class ServiceSpec(override val name: String) : ComponentSpec
data class ViewModelSpec(override val name: String, val repositoryName: String? = null) : ComponentSpec
data class RepositorySpec(override val name: String, val dataSourceName: String? = null) : ComponentSpec
