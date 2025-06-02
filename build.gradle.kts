plugins {
    id("org.jetbrains.intellij.platform") version "2.1.0"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.24"
}

group = "com.halibiram"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        androidStudio("2025.1.1")
        bundledPlugins("android", "Kotlin", "org.jetbrains.plugins.gradle")
        pluginVerifier()
        zipSigner()
        instrumentationTools()
    }
    
    // Google AI SDKs
    implementation("com.google.ai.client.generativeai:generativeai:0.7.0")
    implementation("com.google.firebase:firebase-ai-logic:1.0.0")
    
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.8.1")
    
    // Serialization & HTTP
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("io.ktor:ktor-client-core:2.3.11")
    implementation("io.ktor:ktor-client-cio:2.3.11")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.11")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.11")
    
    // Caching
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
    
    // Testing
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.24")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
    testImplementation("io.mockk:mockk:1.13.11")
}

intellijPlatform {
    pluginConfiguration {
        version = providers.gradleProperty("pluginVersion")
        
        ideaVersion {
            sinceBuild = providers.gradleProperty("pluginSinceBuild")
            untilBuild = providers.gradleProperty("pluginUntilBuild")
        }
    }
    
    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }
    
    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
    }
}
