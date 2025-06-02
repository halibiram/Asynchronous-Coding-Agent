package com.example.asyncagent.analysis

// Placeholder data classes and enums for Project Analysis
data class ProjectContext(
    val projectType: String, // Simplified for now
    val targetSdk: Int,
    val minSdk: Int,
    val architecture: String, // Simplified for now
    val dependencies: List<String>, // Simplified for now
    val codeStyle: String, // Simplified for now
    val existingFiles: List<String> // Simplified for now
)

data class CodePattern(val name: String, val description: String)

enum class ArchitectureType {
    MVVM, MVP, MVI, CLEAN_ARCHITECTURE, UNKNOWN
}

data class Dependency(val groupId: String, val artifactId: String, val version: String)

data class DependencyGraph(val projectDependencies: List<Dependency>, val moduleDependencies: Map<String, List<Dependency>>)
