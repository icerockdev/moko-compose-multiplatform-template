@file:Suppress("OPT_IN_IS_NOT_ENABLED")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    id("dev.icerock.mobile.multiplatform-network-generator")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
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
        val mokoMvvmVersion = extra["moko.mvvm.version"] as String
        val mokoNetworkVersion = extra["moko.network.version"] as String
        val mokoResourcesVersion = extra["moko.resources.version"] as String
        val ktorVersion = extra["ktor.version"] as String

        val commonMain by getting {

            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation("dev.icerock.moko:mvvm-core:$mokoMvvmVersion")
                implementation("dev.icerock.moko:network:$mokoNetworkVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("dev.icerock.moko:mvvm-core:$mokoMvvmVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("dev.icerock.moko:network:$mokoNetworkVersion")
                implementation("dev.icerock.moko:resources:$mokoResourcesVersion")
                implementation("dev.icerock.moko:biometry:0.2.0")
//                implementation("dev.icerock.moko:biometry-iosarm64:0.2.0")

//                api("dev.icerock.moko:resources-compose:0.20.1")

                //Could not resolve all dependencies for configuration ':shared:iosSimulatorArm64CompileKlibraries'.
                //Could not resolve dev.icerock.moko:biometry:0.2.0.
                //implementation("dev.icerock.moko:biometry:0.2.0")
            }
        }

        val androidMain by getting {

            dependencies {
                api("androidx.activity:activity-compose:1.6.1")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.9.0")
                api("io.ktor:ktor-client-okhttp:$ktorVersion")
            }
        }
        val iosMain by getting {
            dependencies {
                api("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }

        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)

        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                api("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.6.4")
            }
        }
    }
}

mokoNetwork {
    spec("jokes") {
        inputSpec = file("src/api/openapi.yml")
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.myapplication.common"
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
