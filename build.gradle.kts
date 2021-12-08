import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.5.0"
    kotlin("plugin.jpa") version "1.5.0"
//    kotlin("kapt") version "1.3.61" // annotation processing을 위한 kapt
    kotlin("plugin.allopen") version "1.5.0"
    kotlin("kapt") version "1.5.0"
}

group = "com.logstashconfiggenerator"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.querydsl:querydsl-jpa")
    implementation ("org.mariadb.jdbc:mariadb-java-client:2.1.2")


    runtimeOnly("mysql:mysql-connector-java")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//    annotationProcessor("com.querydsl:querydsl-apt:4.2.2:jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    kapt(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
//    kapt("org.springframework.boot:spring-boot-configuration-processor")
}

sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class){
    kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
