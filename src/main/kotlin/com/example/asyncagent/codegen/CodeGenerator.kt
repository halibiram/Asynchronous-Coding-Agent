package com.example.asyncagent.codegen

interface CodeGenerator {
    suspend fun generateActivity(spec: ActivitySpec): GeneratedCode
    suspend fun generateFragment(spec: FragmentSpec): GeneratedCode
    suspend fun generateService(spec: ServiceSpec): GeneratedCode
    suspend fun generateViewModel(spec: ViewModelSpec): GeneratedCode
    suspend fun generateRepository(spec: RepositorySpec): GeneratedCode
}
