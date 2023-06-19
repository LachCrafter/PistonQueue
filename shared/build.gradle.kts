plugins {
    id("pq.shadow-conventions")
}

dependencies {
    implementation("org.spongepowered:configurate-yaml:4.1.2")
    compileOnly("net.pistonmaster:pistonmotd-api:5.0.1")
    compileOnly("com.google.guava:guava:32.0.1-jre")
}
