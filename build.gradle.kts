import org.gradle.api.tasks.compile.JavaCompile


plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.kaio"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")
}
tasks.named<JavaCompile>("compileJava") {
    options.compilerArgs.apply {
        // limpa flags antigas, se quiser garantir
        clear()
        add("-parameters")
    }
}
tasks.named<JavaCompile>("compileTestJava") {
    options.compilerArgs.apply {
        clear()
        add("-parameters")
    }
}

tasks.withType<Test> {
	useJUnitPlatform()
}




