group = "net.patrickpfeifer.intellij.plugins"
version = "0.0.1-SNAPSHOT"

val junitVersion = "5.8.2"

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm")  version "1.9.25"
    id("org.jetbrains.intellij.platform") version "2.0.1"
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

sourceSets["main"].java.srcDirs("src/main/gen")

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")

    intellijPlatform {
        create("IC", "2024.2.0.1")
        instrumentationTools()
        pluginVerifier()
        zipSigner()
//        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)
    }
}

intellijPlatform {

    pluginConfiguration {
        version = project.version.toString()

        ideaVersion {
            sinceBuild = "242"
//            untilBuild = "242.*"
        }
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
        channels = listOf("default")
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}
