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
    const val ktlint = "9.4.1"

    const val gradleVersionPlugin = "0.37.0"

    // code coverage
    //const val jacoco = "0.8.5"

    // static code analysis
    const val detekt = "1.15.0"

    // testing
    const val unitTestJunit = "4.13.1"
    const val testCoreKtx = "1.2.0"
    const val androidXTest = "1.2.0"
    const val androidArchCoreTest = "2.1.0"
    const val integrationTestJunit = "1.1.1"
    const val integrationTestTruthAssertion = "1.2.0"
    const val espressoCore = "3.3.0"
    const val espressoContrib = "3.3.0"
    const val espressoIntent = "3.3.0"
    const val espressoIdlingResource = "3.2.0"
}

object Libraries {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val coreKotlinExtensions = "androidx.core:core-ktx:${Versions.coreKotlinExtensions}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
    const val navHostFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navHostFragment}"
    const val navHostUi = "androidx.navigation:navigation-ui:${Versions.navHostFragment}"
    const val unitTestJunit = "junit:junit:${Versions.unitTestJunit}"
    const val integrationTestJunit = "androidx.test.ext:junit:${Versions.integrationTestJunit}"
    const val integrationTestTruthAssertion = "androidx.test.ext:truth:${Versions.integrationTestTruthAssertion}"
    const val coreKotlinExtTest = "androidx.test:core-ktx:${Versions.testCoreKtx}"
    const val androidXTest = "androidx.test:core:${Versions.androidXTest}"
    const val androidArchCoreTest = "androidx.arch.core:core-testing:${Versions.androidArchCoreTest}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoContrib}"
    const val espressoIdlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoIdlingResource}"
    const val espressoIntent = "androidx.test.espresso:espresso-intents:${Versions.espressoIntent}"
}

object BuildPlugins {
    const val klintGradlePlugin = "org.jlleitschuh.gradle.ktlint"
    const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    const val detektGradlePlugin = "io.gitlab.arturbosch.detekt"
    const val jacocoScriptPlugin = "scriptplugins.jacoco-report"
}