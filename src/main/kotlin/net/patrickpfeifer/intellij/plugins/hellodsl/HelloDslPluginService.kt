package net.patrickpfeifer.intellij.plugins.hellodsl

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
class HelloDslPluginService(project: Project) {

    init {
        thisLogger().info("Initializing MyFirstIntellijPlugin for " + project.name)
    }

    fun getRandomNumber() = (1..100).random()
}
