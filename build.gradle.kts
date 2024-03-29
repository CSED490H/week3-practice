plugins {
    java
}

group = "edu.postech.csed332"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.generateGrammarSource {
    //TODO: pass the argument -visitor to this task.
    arguments = arguments + listOf("-visitor", "-no-listener")
}
