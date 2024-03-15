plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.apache.activemq/activemq-all
    implementation ("org.apache.activemq:activemq-all:6.0.1")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    implementation ("org.apache.logging.log4j:log4j-core:2.23.1")


}

tasks.test {
    useJUnitPlatform()
}