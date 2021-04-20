import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
repositories {
    mavenCentral()
    google()
    jcenter()
}

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        create("core-binary-plugin") {
            id = "core-binary-plugin"
            implementationClass = "com.github.changui.binaryplugins.CoreBinaryPlugin"
        }
    }
}

buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.31")
    }
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

dependencies {
    implementation("com.android.tools.build:gradle:4.1.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.31")
    implementation("com.android.tools.build:gradle-api:4.1.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.61")
    implementation(kotlin("script-runtime"))
    implementation("org.jacoco:org.jacoco.core:0.8.5")
}