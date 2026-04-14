plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.10"
    application
    id("co.uzzu.dotenv.gradle") version "4.0.0"
}

group = "com.gainsight"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/ust-partner-demo-sandbox-1-org/test-13-04-26-02")
        credentials {
            username = System.getenv("GPR_USERNAME") ?: ""
            password = System.getenv("GPR_PASSWORD") ?: ""
        }
    }
}

val kotlinVersion = "2.3.10"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    
    // Private library dependency - This will cause CodeQL to fail without credentials
    implementation("com.ustpartnerdemo:sample-library:1.0.0")
    
    // Some common dependencies like staircase-backend
    implementation("ch.qos.logback:logback-core:1.5.32")
    implementation("org.slf4j:slf4j-api:2.0.16")
    
    // Servlet API for vulnerability testing
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    
    // H2 database for testing
    implementation("com.h2database:h2:2.2.224")
}

application {
    mainClass.set("com.ustpartnerdemo.app.MainKt")
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
