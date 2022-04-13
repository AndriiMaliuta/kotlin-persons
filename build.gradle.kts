import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "com.andmal"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("io.javalin:javalin:4.4.0")
    implementation ("org.slf4j:slf4j-simple:1.7.31")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.12.4")
    testImplementation(kotlin("test"))
    implementation("org.jsoup:jsoup:1.14.3")
    implementation("org.postgresql:postgresql:42.3.3")
    implementation ("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.java-websocket:Java-WebSocket:1.5.2")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation ("org.hibernate:hibernate-core:6.0.0.Final")
    implementation ("org.hibernate.common:hibernate-commons-annotations:6.0.0.Final")
    implementation ("org.hibernate.validator:hibernate-validator:7.0.4.Final")
    implementation ("org.hibernate:hibernate-c3p0:6.0.0.Final")
    implementation ("jakarta.el:jakarta.el-api:5.0.0-RC1")
    // https://mvnrepository.com/artifact/jakarta.platform/jakarta.jakartaee-api
    compileOnly ("jakarta.platform:jakarta.jakartaee-api:9.1.0")
//    testImplementation "org.junit.jupiter:junit-jupiter-api:5.8.1"
//    testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:5.8.1"
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

application {
    mainClass.set("MainKt")
}