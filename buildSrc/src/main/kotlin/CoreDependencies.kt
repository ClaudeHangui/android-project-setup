object Versions {

    // Project configurations
    const val kotlinVersion = "1.3.61"
    const val minSdk = 16
    const val targetSdk = 30
    const val compileSdk = 30
    const val buildTools = "30.0.2"
    const val applicationId = "com.changui.android_project_setup"
    const val applicationVersionCode = 1
    const val applicationVersionName = "1.0"

    // Android core libraries
    const val appCompat = "1.2.0"
    const val materialComponents = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val coreKotlinExtensions = "1.3.2"
    const val navHostFragment = "2.3.5"

    // Code formatter
    const val ktlint = "10.0.0"

    const val gradleVersionPlugin = "0.37.0"

    // code coverage
    //const val jacoco = "0.8.5"

    // static code analysis
    const val detekt = "1.15.0"

    // testing
    const val unitTestJunit = "4.13.1"
    const val integrationTestJunit = "1.1.1"
    const val espressoCore = "3.3.0"
}

object Libraries {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val coreKotlinExtensions = "androidx.core:core-ktx:${Versions.coreKotlinExtensions}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
    //const val jacocoCore = "org.jacoco:org.jacoco.core:${Versions.jacoco}"
    const val unitTestJunit = "junit:junit:${Versions.unitTestJunit}"
    const val integrationTestJunit = "androidx.test.ext:junit:${Versions.integrationTestJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val navHostFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navHostFragment}"
    const val navHostUi = "androidx.navigation:navigation-ui:${Versions.navHostFragment}"
}

object BuildPlugins {
    const val klintGradlePlugin = "org.jlleitschuh.gradle.ktlint"
    const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    const val detektGradlePlugin = "io.gitlab.arturbosch.detekt"
}