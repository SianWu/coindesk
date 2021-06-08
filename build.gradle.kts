import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.4.5"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  war
  kotlin("jvm") version "1.4.32"
  kotlin("plugin.spring") version "1.4.32"
}

group = "com.crm"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.0")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.0")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  // graphql
  implementation("com.graphql-java-kickstart:graphql-java-tools:11.0.0")
  implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:11.0.0")
  // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-jackson:2.9.0")

  developmentOnly("org.springframework.boot:spring-boot-devtools")
  runtimeOnly("org.postgresql:postgresql:42.2.20")
  providedRuntime("org.springframework.boot:spring-boot-starter-undertow")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")

}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
