plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.mohmmed.mosa.eg.news"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mohmmed.mosa.eg.news"
        minSdk = 22
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
        isCoreLibraryDesugaringEnabled = true
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
kapt {
    correctErrorTypes = true
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    
    // for desugring 
     coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
    
    // for scaing 
    //implementation("com.github.Kaaveh:sdp-compose:1.1.0")

    //Splash Api
    implementation("androidx.core:core-splashscreen:1.0.1")
    // dagger
    implementation("com.google.dagger:hilt-android:2.49")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt("com.google.dagger:hilt-android-compiler:2.49")
    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")
    // data store
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    // Compose Foundation
    implementation("androidx.compose.foundation:foundation:1.4.3")
    // Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")
    // Paging 3
    val  paging_version = "3.1.1"
    implementation ("androidx.paging:paging-runtime:$paging_version")
    implementation ("androidx.paging:paging-compose:3.2.0-rc01")

    //Room
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation( "androidx.room:room-ktx:2.6.1")

    val work_version = "2.9.0"
    // (Java only)
    implementation("androidx.work:work-runtime:$work_version")
    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:$work_version")
    // optional - GCMNetworkManager support
    implementation("androidx.work:work-gcm:$work_version")
    // optional - Multiprocess support
    implementation ("androidx.work:work-multiprocess:$work_version")

//    val voyagerVersion = "1.1.0-beta01"
//    // Navigator
//    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
//    // Screen Model
//    implementation("cafe.adriel.voyager:voyager-screenmodel:$voyagerVersion")
//    // BottomSheetNavigator
//    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")
//    // TabNavigator
//    implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
//    // live data
//    implementation("cafe.adriel.voyager:voyager-livedata:$voyagerVersion")
//    // Transitions`
//    implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")
    // gson
    implementation("com.google.code.gson:gson:2.10.1")
    // navigation-compose
    implementation("androidx.navigation:navigation-compose:2.7.7")
    // retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    // pertty time
    implementation("org.ocpsoft.prettytime:prettytime:5.0.4.Final")
    // to show fake data eg: name, emil
    implementation("com.github.javafaker:javafaker:1.0.2")
    // ummalqura hijri calendar
    implementation("com.github.msarhan:ummalqura-calendar:2.0.2")
}
