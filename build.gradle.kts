plugins {
    val kotlinVersion = "1.6.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.11.0-RC"
    id("me.him188.maven-central-publish") version "1.0.0-dev-3"


}

group = "com.hcyacg"
version = "1.1.4-dev-2"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    implementation("org.jsoup:jsoup:1.14.3")
    implementation("org.ini4j:ini4j:0.5.4")

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



mavenCentralPublish {
    artifactId = "BiliBili"
    groupId = "com.hcyacg"
    projectName = "mirai plugins bilibili"
    workingDir = rootProject.buildDir.resolve("pub").apply { mkdirs() }
    // description from project.description by default
    useCentralS01()
    githubProject("Nekoer", "mirai-plugins-bilibili")
    licenseFromGitHubProject("licenseAGPL-3.0", "master")
    publication {
        artifact(tasks.getByName("buildPlugin"))
        artifact(tasks.getByName("buildPluginLegacy"))
    }
}