package net.patrickpfeifer.intellij.plugins.myfirstintellijplugin

import com.intellij.lang.Language

object HelloDslLanguage : Language("HelloDsl") {
    private fun readResolve(): Any = HelloDslLanguage
}
