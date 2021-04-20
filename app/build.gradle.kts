import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("com.android.application")
    `kotlin-android`
    id("core-binary-plugin")
    jacoco
    id("scriptplugins.jacoco-report")
    id(BuildPlugins.klintGradlePlugin) version Versions.ktlint
}

jacoco {
    toolVersion = "0.8.5"
}

// ktlint Configuration
configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
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
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
        reporter(ReporterType.JSON)
        reporter(ReporterType.HTML)
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}


