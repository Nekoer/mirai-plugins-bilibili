plugins {
    val kotlinVersion = "1.6.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"


    id("net.mamoe.mirai-console") version "2.11.0-M2.2"
}

group = "com.hcyacg"
version = "1.1.1"

repositories {
    mavenCentral()
}

dependencies {

    implementation("com.alibaba:fastjson:2.0.1")
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


java {
    withJavadocJar()
    withSourcesJar()
}

tasks.register<Zip>("stuffZip") {
    archiveBaseName.set("stuff")
    from("src/stuff")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = rootProject.name
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set(rootProject.name)
                description.set("The Robot Kotlin SDK on Tencent Channel")
                url.set("https://github.com/Nekoer/mirai-plugins-bilibili")
//                properties.set(mapOf(
//                    "myProp" to "value",
//                    "prop.with.dots" to "anotherValue"
//                ))
                licenses {
                    license {
                        name.set("GNU AFFERO GENERAL PUBLIC LICENSE, Version 3.0")
                        url.set("https://www.gnu.org/licenses/agpl-3.0.en.html")
                    }
                }
                developers {
                    developer {
                        id.set("Nekoer")
                        name.set("Nekoer")
                        email.set("hcyacg@vip.qq.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Nekoer/mirai-plugins-bilibili.git")
                    developerConnection.set("scm:git:ssh://github.com/Nekoer/mirai-plugins-bilibili.git")
                    url.set("https://github.com/Nekoer/mirai-plugins-bilibili")
                }
            }
        }
    }
    repositories {
        maven {
            // change URLs to point to your repos, e.g. http://my.org/repo
            val releasesRepoUrl = uri(layout.buildDirectory.dir("repos/releases"))
            val snapshotsRepoUrl = uri(layout.buildDirectory.dir("repos/snapshots"))
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

nexusPublishing {
    repositories {
        sonatype {  //only for users registered in Sonatype after 24 Feb 2021
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))

            username.set(properties["myNexusTokenUsername"].toString())
            password.set(properties["myNexusTokenPassword"].toString())
        }
    }
}