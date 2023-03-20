@file:Suppress("OPT_IN_IS_NOT_ENABLED")

plugins {
    id("org.jetbrains.compose")
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-network-generator")
    id("org.jetbrains.kotlin.plugin.serialization")
}

version = "1.0-SNAPSHOT"

kotlin {
    android()

    jvm("desktop")

    ios()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val mokoMvvmVersion = extra["mokoMvvm.version"] as String

        val commonMain by getting {

            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation("dev.icerock.moko:mvvm-core:$mokoMvvmVersion")
                implementation("dev.icerock.moko:mvvm-core:0.15.0")
                implementation("dev.icerock.moko:network:0.20.1")
                implementation("io.ktor:ktor-client-core:2.2.4")
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.activity:activity-compose:1.6.1")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.9.0")
                api("io.ktor:ktor-client-okhttp:2.2.4")
            }
        }
        val iosMain by getting
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                api("io.ktor:ktor-client-okhttp:2.2.4")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.6.4")
            }
        }
    }
}

mokoNetwork {
    spec("jokes") {
        inputSpec = file("src/api/openapi.yml")
        isInternal = false
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
