plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    `maven-publish`
}

android {
    namespace = "energy.octopus.coral.ui"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    buildFeatures {
        compose = true
    }

}

group = "com.rdunndev"

publishing {
    publications {
        create<MavenPublication>("ReleaseAar") {
            groupId = group as String?
            artifactId = "coral.ui"
            version = findProperty("lib.version") as String?
            afterEvaluate {
                artifact(tasks.getByName("bundleReleaseAar"))
            }
        }
    }

    repositories {
        maven {
            name = "coral.ui"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.runtime)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    implementation(libs.androidx.material3)

    val composeBom = platform("androidx.compose:compose-bom:2026.03.00")
    implementation(composeBom)

}