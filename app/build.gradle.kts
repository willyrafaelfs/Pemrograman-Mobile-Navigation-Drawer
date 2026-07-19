// File: app/build.gradle.kts (Module-level)
// ==========================================
// Konfigurasi build untuk modul app.
// Di sini kita mendefinisikan semua library/dependency yang dibutuhkan.

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.navdrawerapp"
    compileSdk = 34                          // Versi SDK untuk kompilasi

    defaultConfig {
        applicationId = "com.example.navdrawerapp"
        minSdk = 26                          // Minimal Android 8.0 (Oreo)
        targetSdk = 34                       // Target Android 14
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true                       // Mengaktifkan Jetpack Compose
    }

    composeOptions {
        // Versi Kotlin Compiler Extension untuk Compose
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // === Jetpack Compose BOM (Bill of Materials) ===
    // BOM memastikan semua library Compose menggunakan versi yang kompatibel
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.00"))

    // === Core Android ===
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    // === Jetpack Compose ===
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // === Material3 (desain modern Google) ===
    implementation("androidx.compose.material3:material3")

    // === Material Icons Extended (ikon tambahan) ===
    implementation("androidx.compose.material:material-icons-extended")

    // === Navigation Compose ===
    // Library untuk navigasi antar halaman di Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // === Debug Tools ===
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // === Testing ===
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}
