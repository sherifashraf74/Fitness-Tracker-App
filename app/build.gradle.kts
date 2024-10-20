plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
    id("org.jetbrains.kotlin.kapt") // Corrected plugin ID for kapt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.healthyfitness"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.healthyfitness"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.okhttp)
    implementation(libs.androidx.room.runtime)
    //LocalDateTime
    implementation(libs.threetenabp)
    implementation(libs.androidx.runtime.livedata)
    annotationProcessor(libs.androidx.room.compiler)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.androidx.room.compiler)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.navigation.compose)
    implementation (libs.lottie.compose)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation (libs.accompanist.permissions)

    // retrofit gson
    implementation(libs.converter.gson)

    // room
//    val room_version = "2.6.1"


    implementation(libs.androidx.room.ktx)
//    kapt("androidx.room:room-compiler:$room_version")

    implementation (libs.coil.compose)

    implementation(libs.coil.gif)

    // extended icons
    implementation (libs.androidx.material.icons.extended)


    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation ("androidx.fragment:fragment-ktx:1.8.4")

    // animated navhost
    implementation (libs.accompanist.navigation.animation)

    implementation ("androidx.compose.ui:ui:1.7.4")



    testImplementation(libs.junit)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
    kaptTest(libs.dagger.hilt.compiler)
    testImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
kapt {
    correctErrorTypes = true
}