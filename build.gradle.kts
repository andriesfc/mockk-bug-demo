import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//region Plugins
plugins {
    kotlin("jvm") version "1.5.21"
    `java-library`
}
//endregion

repositories {
    //region Repositories
    mavenCentral()
    //endregion
}

dependencies {

    //region Dependencies
    implementation(kotlin("bom"))
    implementation(kotlin("stdlib-jdk8"))
    //endregion

    //region Test Dependencies
    testImplementation(kotlin("test-junit5"))
    testImplementation(kotlin("reflect"))
    val junit5Version = "5.7.2"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit5Version")
    val mockkVersion = "1.12.0"
    testImplementation("io.mockk:mockk:$mockkVersion")
    //endregion

}

//region Unit Test Configuration
tasks.test {
    useJUnitPlatform()
}
//endregion

//region Compiler Configuration
val javaCompilerLevel = "11"
val kotlinCompileLevel = "1.5"
val javaLanguageVersion = JavaLanguageVersion.of(javaCompilerLevel)

tasks.withType<KotlinCompile> {
    kotlinOptions {
        languageVersion = kotlinCompileLevel
        apiVersion = kotlinCompileLevel
        jvmTarget = javaCompilerLevel
    }
}

javaToolchains {
    javadocToolFor {
        languageVersion.set(javaLanguageVersion)
    }
    compilerFor {
        languageVersion.set(javaLanguageVersion)
    }
}
//endregion





