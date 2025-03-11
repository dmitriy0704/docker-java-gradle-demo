plugins {
    id("java")
    application
}

group = "dev.folomkin"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("dev.folomkin.Main")
}

tasks.jar {
    manifest {
        attributes("Main-Class" to application.mainClass)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}