plugins {
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "dio.santander"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation(buildString {
        append("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.1")
    })
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
	implementation ("com.fasterxml.jackson.core:jackson-databind:2.17.1")
	implementation ("com.fasterxml.jackson.core:jackson-core:2.17.1")
	implementation ("com.fasterxml.jackson.core:jackson-annotations:2.17.1")
	implementation ("com.fasterxml.jackson.datatype:jackson-datatype-hibernate5:2.17.1")
	implementation ("javax.persistence:javax.persistence-api:2.2")
	runtimeOnly(dependencyNotation = "com.h2database:h2")
	runtimeOnly(dependencyNotation = "org.postgresql:postgresql")
	testImplementation(dependencyNotation = "org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly(dependencyNotation = "org.junit.platform:junit-platform-launcher")
}

tasks.jar{
	manifest{
		attributes["Main-Class"] = "dio.santander.store.LojaApplication"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
