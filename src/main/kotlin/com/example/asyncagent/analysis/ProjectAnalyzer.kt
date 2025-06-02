package com.example.asyncagent.analysis

interface ProjectAnalyzer {
    suspend fun analyzeProject(): ProjectContext
    suspend fun identifyCodePatterns(): List<CodePattern>
    suspend fun detectArchitecture(): ArchitectureType
    suspend fun findDependencies(): DependencyGraph
}
