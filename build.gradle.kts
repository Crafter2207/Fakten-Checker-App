// Top-level build file where you can add configuration options common to all sub-projects/modules.
// In app/build.gradle.kts

android {
    // ... other configurations like compileSdk, defaultConfig ...

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17" // Or "1.8" if you use an older setup
    }

    // ... other configurations like buildFeatures, composeOptions ...
}


plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}