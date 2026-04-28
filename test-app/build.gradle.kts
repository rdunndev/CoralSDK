plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "energy.octopus.coral.test_app"
    compileSdk = libs.versions.appconfig.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "energy.octopus.coralsdk"
        minSdk = libs.versions.appconfig.minsdk.get().toInt()
        targetSdk = libs.versions.appconfig.sdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
 }

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.core)
    implementation(libs.androidx.material3)

    implementation(project(":coral:ui"))
}