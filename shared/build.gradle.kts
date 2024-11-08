plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.library)
    alias(libs.plugins.moko.res)
}

kotlin {
    jvm()
    androidTarget()

    sourceSets {
        //  в common main лежат коды для таргета common main
        val commonMain by getting {

            dependencies {
                // compose
                implementation(compose.foundation)
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.material)

                //resources
                api(libs.resources.core)
                api(libs.resources.compose)

                //settings
                implementation(libs.multiplatform.settings)

                //di
                api(libs.koin.core)
            }
        }

        androidMain {
            dependsOn(commonMain)
        }

        jvmMain {
            dependsOn(commonMain)
            dependencies {
                api(compose.desktop.currentOs)
            }
        }
    }

}

multiplatformResources {
    multiplatformResourcesPackage = "example"
}

android {
    namespace = findProperty("app.namespace").toString()
    compileSdk = findProperty("android.compileSdk").toString().toInt()

    defaultConfig {
        minSdk = findProperty("android.minSdk").toString().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}