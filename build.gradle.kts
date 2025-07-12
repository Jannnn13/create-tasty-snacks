plugins {
    id("fabric-loom") version "1.5.6"
    kotlin("jvm") version "1.9.22"
}

group = "com.jannik.create_tasty_snacks"
version = "1.0.0"

repositories {
    repositories {
    maven("https://maven.fabricmc.net/")
    mavenCentral()
}
}

dependencies {
    minecraft("com.mojang:minecraft:1.20.1")
    mappings("net.fabricmc:yarn:1.20.1+build.10:v2")
    modImplementation("net.fabricmc:fabric-loader:0.14.21")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.91.1+1.20.1")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.10.10+kotlin.1.9.10")
    implementation(kotlin("stdlib"))
}

tasks.withType<JavaCompile> {
    options.release.set(17)
}

tasks.named("build") {
    dependsOn("remapJar")
}

java {
    withSourcesJar()
}
