plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.yoru_choi"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    //api e.g) @RestController
    implementation("org.springframework.boot:spring-boot-starter-web")
    //mongodb
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    // have to annotation validation
    implementation("org.springframework.boot:spring-boot-starter-validation:3.3.3")

    // spring aop TODO check this implementation
    implementation("org.springframework.boot:spring-boot-starter-aop")

    implementation("org.reflections:reflections:0.10.2")


    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
