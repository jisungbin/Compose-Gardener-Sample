plugins {
  kotlin("jvm") version "2.0.0"
  kotlin("plugin.compose") version "2.0.0"
  application
  `java-base`
}

application {
  mainClass = "MarkdownKt"
}

repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation("androidx.compose.runtime:runtime:1.6.8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
}
