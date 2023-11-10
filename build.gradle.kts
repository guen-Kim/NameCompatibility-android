buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")

    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("com.android.library") version "8.1.1" apply false
    id("com.google.dagger.hilt.android") version DaggerHilt.DAGGER_HILT_VERSION apply false
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}