import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("com.android.application")
    `kotlin-android`
    id("core-binary-plugin")
    jacoco
    id("scriptplugins.jacoco-report")
}

jacoco {
    toolVersion = "0.8.5"
}

