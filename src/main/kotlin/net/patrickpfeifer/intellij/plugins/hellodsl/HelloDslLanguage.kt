package net.patrickpfeifer.intellij.plugins.hellodsl

import com.intellij.lang.Language

object HelloDslLanguage : Language("HelloDsl") {
    private fun readResolve(): Any = HelloDslLanguage
}
