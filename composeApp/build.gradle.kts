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

            implementation("io.ktor:ktor-client-okhttp:2.3.7")
            implementation("io.ktor:ktor-client-android:2.2.4")
            implementation("io.ktor:ktor-client-logging:2.2.4")

            implementation(libs.koin.android)

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            implementation("dev.icerock.moko:mvvm-core:0.16.1")
            implementation("dev.icerock.moko:mvvm-compose:0.16.1")
            implementation("dev.icerock.moko:mvvm-flow:0.16.1")
            implementation("dev.icerock.moko:mvvm-flow-compose:0.16.1")
            implementation("org.jetbrains.kotlinx:atomicfu:0.23.1")

            implementation("io.ktor:ktor-client-core:2.3.7")
            implementation("io.ktor:ktor-client-serialization:2.2.4")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.4")
            implementation("io.ktor:ktor-client-content-negotiation:2.2.4")


            api("io.github.qdsfdhvh:image-loader:1.7.3")

            implementation("media.kamel:kamel-image:0.9.1")
            implementation("co.touchlab:kermit:2.0.2")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

            val voyagerVersion = "1.0.0"

            // Multiplatform

            // Navigator
            implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")

            // Screen Model
            implementation("cafe.adriel.voyager:voyager-screenmodel:$voyagerVersion")

            // BottomSheetNavigator
            implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")

            // TabNavigator
            implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")

            // Transitions
            implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")

            implementation(libs.koin.core)
            implementation(libs.koin.compose)

        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.7.3")
            implementation("io.ktor:ktor-client-cio:2.2.4")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.7")
            implementation("io.ktor:ktor-client-ios:2.2.4")
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
