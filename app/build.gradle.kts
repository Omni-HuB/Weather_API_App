plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

//    id ("dagger.hilt.android.plugin")
//    id ("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.weather_api_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weather_api_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation ("com.google.dagger:hilt-android:2.49")
    ksp ("com.google.dagger:hilt-android-compiler:2.40.5")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    ksp ("androidx.hilt:hilt-compiler:1.2.0")

//    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
//    implementation("io.coil-kt:coil-compose:2.4.0")
//
////    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
////    implementation ("com.squareup.retrofit2:converter-gson:2.5.0")
////
//    implementation ("androidx.activity:activity-compose:1.9.0")
////    implementation ("androidx.compose.ui:ui:$compose_version")
////    implementation ("androidx.compose.material:material:$compose_version")
////    implementation ("androidx.compose.ui:ui-tooling:$compose_version")
//    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation ("androidx.compose.ui:ui:1.6.6")
    implementation ("androidx.compose.material:material:1.6.6")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.6.6")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.activity:activity-compose:1.9.0")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")


}