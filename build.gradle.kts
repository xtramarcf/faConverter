import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.4"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(files("build\\libs\\openedge.jar"))
    implementation(files("build\\libs\\amqmf.jar"))
    implementation(files("build\\libs\\debugger.jar"))
    implementation(files("build\\libs\\fathomws.jar"))
    implementation(files("build\\libs\\juniper.jar"))
    implementation(files("build\\libs\\messages.jar"))
    implementation(files("build\\libs\\o4glrt.jar"))
    implementation(files("build\\libs\\osmetrics.jar"))
    implementation(files("build\\libs\\pasplugin.jar"))
    implementation(files("build\\libs\\pool.jar"))
    implementation(files("build\\libs\\progress.jar"))
    implementation(files("build\\libs\\prorepl.jar"))
    implementation(files("build\\libs\\prosp.jar"))
    implementation(files("build\\libs\\schema.jar"))
    implementation(files("build\\libs\\sqlexp.jar"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.hibernate:hibernate-entitymanager:6.0.0.Alpha7")
    implementation("org.hibernate.orm:hibernate-core:6.2.5.Final")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.1.2")
    implementation("org.apache.poi:poi:5.2.2")
    implementation("org.apache.poi:poi-ooxml:5.2.2")
    implementation("org.jboss.logging:jboss-logging:3.5.0.Final")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
