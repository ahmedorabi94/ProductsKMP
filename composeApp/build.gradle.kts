import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    kotlin("plugin.serialization") version "1.8.10"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    jvm("desktop")
   // ios()


    listOf(
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
        //    isStatic = true
            binaryOption("bundleId", "org.orabi.prodcuts.ComposeApp")
            linkerOpts  += "-ld64"
        }
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)

            implementation(libs.androidx.appcompat)

            implementation(libs.ktor.client.okhttp)
            implementation(libs.ktor.client.android)
            implementation(libs.ktor.client.logging)

            implementation(libs.koin.android)

//            api(libs.coil3.gif)
//            api(libs.coil3.svg)
//            api(libs.coil3.core)
//            api(libs.coil3.video)

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation(libs.mvvm.core)
            implementation(libs.moko.mvvm.compose)
            implementation(libs.moko.mvvm.flow)
            implementation(libs.moko.mvvm.flow.compose)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.content.negotiation)

          //  api(libs.coil3)
          //  api(libs.coil3.network)

            api(libs.image.loader)

            implementation(libs.kermit)
            implementation(libs.kotlinx.serialization.json)

            // Navigator
            implementation(libs.voyager.navigator)

            // Screen Model
            implementation(libs.voyager.screenmodel)

            // BottomSheetNavigator
            implementation(libs.voyager.bottom.sheet.navigator)

            // TabNavigator
            implementation(libs.voyager.tab.navigator)

            // Transitions
            implementation(libs.voyager.transitions)

            implementation(libs.koin.core)
            implementation(libs.koin.compose)

        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.ktor.client.cio)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.ktor.client.ios)
        }
    }
}

android {
    namespace = "org.orabi.prodcuts"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.orabi.prodcuts"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.orabi.prodcuts"
            packageVersion = "1.0.0"
        }
    }
}
