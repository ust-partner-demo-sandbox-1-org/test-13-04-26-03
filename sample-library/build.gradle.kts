plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.10"
    id("maven-publish")
}

group = "com.ustpartnerdemo"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.3.10")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ust-partner-demo-sandbox-1-org/test-13-04-26-02")
            credentials {
                username = System.getenv("GPR_USERNAME")
                password = System.getenv("GPR_PASSWORD")
            }
        }
    }
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}
