package net.patrickpfeifer.intellij.plugins.myfirstintellijplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader

class HelloDslFileType : LanguageFileType(HelloDslLanguage) {

    override fun getName() = "HelloDsl File"
    override fun getDescription() = "HelloDsl language file"
    override fun getDefaultExtension() = "hdsl"
    override fun getIcon() = IconLoader.getIcon("/icons/jar-gray.png", HelloDslFileType::class.java)
}
