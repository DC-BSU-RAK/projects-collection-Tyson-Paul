plugins {

    // Android application setup
    alias(libs.plugins.android.application)

    // Enables Jetpack Compose with Kotlin
    alias(libs.plugins.kotlin.compose)
}

android {

    // Project package name
    namespace = "com.tyson.moodcalculator"

    compileSdk {
        version = release(36)
    }

    defaultConfig {

        // Application ID
        applicationId = "com.tyson.moodcalculator"

        // Minimum Android version supported
        minSdk = 24

        // Target Android version
        targetSdk = 36

        // App version details
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        release {

            // Disables code shrinking for release build
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Java compatibility settings
    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Enables Jetpack Compose UI
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Core Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Compose activity support
    implementation(libs.androidx.activity.compose)

    // Compose UI libraries
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)

    // Material Design 3 components
    implementation(libs.androidx.compose.material3)

    // Additional Material icons
    implementation("androidx.compose.material:material-icons-extended")

    // Testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Compose testing support
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    // Debugging tools
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}