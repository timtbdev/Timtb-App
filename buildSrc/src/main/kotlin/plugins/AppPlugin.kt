package plugins


import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.kotlin.dsl.project
import org.gradle.kotlin.dsl.withType

class AppPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        applyPlugins(project)
        applyAppExtension(project)
    }

    // Configure plugins
    private fun applyPlugins(project: Project) {
        project.plugins.apply {
            apply(Plugins.KotlinAndroid)
            apply(Plugins.KotlinAndroidExtension)
            apply(Plugins.KotlinKapt)
            apply(Plugins.Google)
            apply(Plugins.FirebaseCrash)
            apply(Plugins.FirebasePerf)
            apply(Plugins.Navigation)
            apply(Plugins.Hilt)
        }
    }

    //Configure Android block
    private fun applyAppExtension(project: Project) {

        val extension = project.extensions.getByName("android")
                as? AppExtension ?: return
        extension.apply {
            compileSdkVersion(App.CompileSdk)
            buildToolsVersion(App.BuildTools)

            defaultConfig {
                applicationId = App.Id
                minSdkVersion(App.MinSdk)
                targetSdkVersion(App.TargetSdk)
                versionCode = App.VersionCode
                versionName = App.VersionName
                vectorDrawables.useSupportLibrary = true
                multiDexEnabled = true
                testInstrumentationRunner = App.AndroidJunitRunner
            }

            buildTypes {
                named("debug") {
                    applicationIdSuffix = ".dev"
                    versionNameSuffix = "-dev"
                    buildConfigField("String", "API_BASE", "http://www.timtb.dev/api/")
                    isMinifyEnabled = false
                    isDebuggable = true
                    isTestCoverageEnabled = true
                    manifestPlaceholders["crashlyticsEnabled"] = false
                }
                named("release") {
                    buildConfigField("String", "API_BASE", "http://www.timtb.dev/api/")
                    // Enables code shrinking for the release build type.
                    isMinifyEnabled = true
                    isDebuggable = false
                    isShrinkResources = true
                    manifestPlaceholders["crashlyticsEnabled"] = true
                    proguardFiles("/settings/proguard_files/proguard-square-retrofit.pro")
                    proguardFiles("/settings/proguard_files/proguard-gson.pro")
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
            sourceSets {
                named("main") {
                    java {
                        srcDir("src/main/kotlin")
                    }
                }

                named("debug") {
                    java {
                        srcDir("src/debug/kotlin")
                    }
                }
            }

            buildFeatures.apply {
                viewBinding = true
                compose = true

            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            project.tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    freeCompilerArgs = listOf(
                        "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                        "-Xopt-in=kotlinx.coroutines.FlowPreview",
                        "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
                        "-Xopt-in=kotlin.time.ExperimentalTime"
                    )
                    jvmTarget = "${JavaVersion.VERSION_1_8}"
                }

            }

            composeOptions {
                kotlinCompilerExtensionVersion = "1.0.0-beta01"
            }

            lintOptions {
                isCheckReleaseBuilds = false
            }

            packagingOptions {
                exclude("META-INF/AL2.0")
                exclude("META-INF/LGPL2.1")
            }

            applicationVariants.forEach { variant ->
                variant.outputs.forEach { output ->
                    val outputImpl = output as BaseVariantOutputImpl
                    val project = project.name
                    val sep = "_"
                    val flavor = variant.flavorName
                    val buildType = variant.buildType.name
                    val version = variant.versionName

                    val newApkName = "$project$sep$flavor$sep$buildType$sep$version.apk"
                    outputImpl.outputFileName = newApkName
                }
            }

        }
    }

    // Configure dependencies
}
