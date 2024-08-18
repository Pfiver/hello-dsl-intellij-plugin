package net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.psi

import com.intellij.psi.tree.IElementType
import net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.HelloDslLanguage

class HelloDslElementType(debugName: String) : IElementType(debugName, HelloDslLanguage)
