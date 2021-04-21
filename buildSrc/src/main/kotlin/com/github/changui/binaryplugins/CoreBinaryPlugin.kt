package com.github.changui.binaryplugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CoreBinaryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyAndroidApplicationConfig()
            applyDependenciesConfig()
        }
    }

    private fun Project.applyAndroidApplicationConfig() {
        android.run {
            compileSdkVersion(Versions.compileSdk)
            buildToolsVersion(Versions.buildTools)
            defaultConfig {
                applicationId(Versions.applicationId)
                minSdkVersion(Versions.minSdk)
                targetSdkVersion(Versions.targetSdk)
                versionCode(Versions.applicationVersionCode)
                versionName(Versions.applicationVersionName)
                testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
            }
            lintOptions {
                isCheckReleaseBuilds = false
                isAbortOnError = true
                isIgnoreWarnings = true
                isQuiet = true
                warning("InvalidPackage")
                checkOnly("HandlerLeak")
                disable("StringFormatInvalid", "NewApi")
            }
            buildTypes {
                getByName("debug") {
                    isMinifyEnabled = false
                    isTestCoverageEnabled = true
                }
                getByName("release") {
                    isMinifyEnabled = true
                    proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
                }
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            testOptions{
                animationsDisabled = true
                unitTests.apply {
                    isReturnDefaultValues = true
                    isIncludeAndroidResources = true
                }
            }
        }
    }

    private fun Project.applyDependenciesConfig() {
        dependencies {
            implementations().forEach { dependency ->
                add("implementation", dependency)
            }
            testImplementation().forEach { unitTestDependency ->
                add("testImplementation", unitTestDependency)
            }
            androidTestImplementation().forEach { androidTestDependency ->
                add("androidTestImplementation", androidTestDependency)

            }
        }
    }




    /**
     * Access the `android` extension of this project. If the project is not an
     * Android app or library module, this method will throw.
     */
    private val Project.android : BaseExtension
        get() = extensions.findByName("android") as? BaseExtension
            ?: error("Not an Android module: $name")

    private fun implementations(): List<String> {
        val coreDependencyList = mutableListOf<String>()
        coreDependencyList.add(Libraries.appCompat)
        coreDependencyList.add(Libraries.coreKotlinExtensions)
        coreDependencyList.add(Libraries.kotlinStdLib)
        coreDependencyList.add(Libraries.constraintLayout)
        coreDependencyList.add(Libraries.materialComponents)
        coreDependencyList.add(Libraries.navHostFragment)
        coreDependencyList.add(Libraries.navHostUi)
        return coreDependencyList.distinct()
    }

    private fun testImplementation(): List<String> {
        val unitTestDependencyList = mutableListOf<String>()
        unitTestDependencyList.add(Libraries.unitTestJunit)
        unitTestDependencyList.add(Libraries.androidXTest)
        unitTestDependencyList.add(Libraries.androidArchCoreTest)
        unitTestDependencyList.add(Libraries.coreKotlinExtTest)
        return unitTestDependencyList.distinct()
    }

    private fun androidTestImplementation(): List<String> {
        val integrationTestDependencyList = mutableListOf<String>()
        integrationTestDependencyList.add(Libraries.integrationTestJunit)
        integrationTestDependencyList.add(Libraries.integrationTestTruthAssertion)
        integrationTestDependencyList.add(Libraries.androidXTest)
        integrationTestDependencyList.add(Libraries.coreKotlinExtTest)
        integrationTestDependencyList.add(Libraries.espressoCore)
        integrationTestDependencyList.add(Libraries.espressoContrib)
        integrationTestDependencyList.add(Libraries.espressoIdlingResource)
        integrationTestDependencyList.add(Libraries.espressoIntent)
        return integrationTestDependencyList.distinct()
    }
}