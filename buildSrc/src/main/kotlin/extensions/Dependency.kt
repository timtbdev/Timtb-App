import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/** Adds a dependency debugImplementation to the configuration. **/
fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)

/** Adds a dependency implementation to the configuration. **/
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

/** Adds a dependency api to the configuration. **/
fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)

/** Adds a dependency kapt to the configuration. **/
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

/** Adds a dependency testImplementation to the configuration. **/
fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)

/** Adds a dependency testRuntimeOnly to the configuration. **/
fun DependencyHandler.testRuntimeOnly(dependencyNotation: String): Dependency? =
    add("testRuntimeOnly", dependencyNotation)

/** Adds a dependency androidTestImplementation to the configuration. **/
fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)