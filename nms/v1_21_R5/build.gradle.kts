import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.gradle.jvm.toolchain.JavaLanguageVersion

plugins {
    alias(libs.plugins.conventions.paperweight)
}

dependencies {
    paperweight.paperDevBundle("1.21.8-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.release = 21
    }
    compileKotlin {
        compilerOptions.jvmTarget = JvmTarget.JVM_21
    }
}

// Paperweight's Codebook for this 1.21.8 bundle cannot inspect Java 25 classes.
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

kotlin {
    jvmToolchain(21)
}
