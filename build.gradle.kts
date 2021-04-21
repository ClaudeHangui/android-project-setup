// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra["kotlin_version"] = "1.3.31"
    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.31")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}


plugins {
    id(BuildPlugins.detektGradlePlugin) version Versions.detekt
    id(BuildPlugins.klintGradlePlugin) version Versions.ktlint
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
    withType<io.gitlab.arturbosch.detekt.Detekt>{
        configureEach {
            jvmTarget = "1.8"
        }
    }
}

// Detekt Configuration
detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    config = files("$projectDir/config/detekt/detekt.yml")
    reports {
        xml {
            enabled = true
            destination = file("build/reports/detekt.xml")
        }
        // Enable/Disable HTML report (default: true)
        html {
            enabled = true
            destination = file("build/reports/detekt.html")
        }
        // Enable/Disable TXT report (default: true)
        txt {
            enabled = true
            destination = file("build/reports/detekt.txt")
        }
    }
}

// ktlint Configuration
ktlint {
    debug.set(true)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    outputColorName.set("RED")
    ignoreFailures.set(true)
    enableExperimentalRules.set(true)
    coloredOutput.set(true)
    disabledRules.set(setOf("final-newline"))

    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.JSON)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}