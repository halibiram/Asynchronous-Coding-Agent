// build.gradle.kts
plugins {
    id("org.jetbrains.intellij.platform") version "2.1.0" // Latest 2025 version
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.24"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    // IntelliJ Platform dependencies for 2025
    intellijPlatform {
        androidStudio("2025.1.1.12") // Latest Android Studio Narwhal
        bundledPlugins("android", "Kotlin", "org.jetbrains.plugins.gradle")
        pluginVerifier()
        zipSigner()
        instrumentationTools()
    }

    // Google AI & Firebase SDKs (2025 unified SDK)
    implementation("com.google.firebase:firebase-ai-logic:1.0.0") // New unified SDK
    implementation("com.google.ai.client.generativeai:generativeai:0.7.0")

    // Kotlin Coroutines for async operations
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.8.1")

    // JSON serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    // HTTP client for API calls
    implementation("io.ktor:ktor-client-core:2.3.11")
    implementation("io.ktor:ktor-client-cio:2.3.11")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.11")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.11")

    // Testing dependencies
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.24")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
    testImplementation("io.mockk:mockk:1.13.11")
}

intellijPlatform {
    pluginConfiguration {
        version = "1.0.0"

        // Plugin compatibility
        ideaVersion {
            sinceBuild = "241" // Corresponds to 2024.1
            untilBuild = "251.*" // Corresponds to 2025.1.*
        }
    }

    signing {
        certificateChain = System.getenv("CERTIFICATE_CHAIN")
        privateKey = System.getenv("PRIVATE_KEY")
        password = System.getenv("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = System.getenv("PUBLISH_TOKEN")
        channels = listOf("default")
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}
