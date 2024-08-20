package net.patrickpfeifer.intellij.plugins.hellodsl

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import javax.swing.JButton

class HelloDslToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class MyToolWindow(toolWindow: ToolWindow) {

        private val service = toolWindow.project.service<HelloDslPluginService>()

        fun getContent() = JBPanel<JBPanel<*>>().apply {
            val label = JBLabel("No number yet.")

            add(label)
            add(JButton("Shuffle").apply {
                addActionListener {
                    label.text = service.getRandomNumber().toString()
                }
            })
        }
    }
}
