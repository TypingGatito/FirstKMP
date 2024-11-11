plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.library)
    alias(libs.plugins.moko.res)
    alias(libs.plugins.sqldelight)
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
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)

                //resources
                api(libs.resources.core)
                api(libs.resources.compose)

                //settings
                implementation(libs.multiplatform.settings)

                //di
                api(libs.koin.core)

                //time
                implementation(libs.datetime)

                //sqldelight
                implementation(libs.sqldelight.coroutines.extensions)
            }
        }

        androidMain {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.sqldelight.android.driver)
            }
        }

        jvmMain {
            dependsOn(commonMain)
            dependencies {
                api(compose.desktop.currentOs)
                implementation(libs.sqldelight.desktop.driver)
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


sqldelight {
    databases {
        create("AppDb") {
            packageName.set("example")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/db"))
        }
    }
}