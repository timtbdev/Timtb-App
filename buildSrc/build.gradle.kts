plugins {
    `kotlin-dsl`
}

kotlin {
    sourceSets {
        named("main") {
            kotlin.apply {
                srcDir("buildSrc/src/main/kotlin")
            }
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(Plugins.Gradle)
    implementation(Plugins.Kotlin)
}