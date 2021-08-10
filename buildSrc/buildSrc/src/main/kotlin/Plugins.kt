object Plugins {
    // Top level plugins
    const val ApplicationPlugin = "android-binary-plugin"
    const val AndroidApplication = "com.android.application"
    const val VersionUpdate = "com.github.ben-manes.versions"
    const val Ktlint = "org.jlleitschuh.gradle.ktlint"
    const val Detekt = "io.gitlab.arturbosch.detekt"

    // Module plugins
    const val KotlinAndroid = "kotlin-android"
    const val KotlinAndroidExtension = "kotlin-android-extensions"
    const val KotlinKapt = "kotlin-kapt"
    const val Google = "com.google.gms.google-services"
    const val FirebaseCrash = "com.google.firebase.crashlytics"
    const val FirebasePerf = "com.google.firebase.firebase-perf"
    const val Navigation = "androidx.navigation.safeargs.kotlin"
    const val Hilt = "dagger.hilt.android.plugin"

    // Project
    val Gradle: String
        get() = "com.android.tools.build:gradle:${Versions.Gradle}"
    val Kotlin: String
        get() = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}"
}