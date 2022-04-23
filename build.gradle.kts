plugins {
    val kotlinVersion = "1.6.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.11.0-M2.2"
}

group = "com.hcyacg"
version = "1.1"

repositories {
    mavenCentral()
}

dependencies {

    implementation("com.alibaba:fastjson:1.2.80")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    implementation("org.jsoup:jsoup:1.14.3")
    implementation("org.ini4j:ini4j:0.5.4")


//    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.5")

    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")

    implementation(fileTree(mapOf("dir" to "src/main/resources/libs", "include" to listOf("*.jar"))))

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}