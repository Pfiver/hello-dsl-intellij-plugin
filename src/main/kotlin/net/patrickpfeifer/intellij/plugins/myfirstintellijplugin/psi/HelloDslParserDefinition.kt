package net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.HelloDslFileType
import net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.HelloDslLanguage
import net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.HelloDslLexerAdapter
import net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.HelloDslParser

class HelloDslParserDefinition : ParserDefinition {

    override fun createParser(project: Project) = HelloDslParser()
    override fun createLexer(project: Project) = HelloDslLexerAdapter()

    override fun getFileNodeType() = IFileElementType(HelloDslLanguage)
    override fun getStringLiteralElements() = TokenSet.EMPTY
    override fun getCommentTokens() = TokenSet.create(HelloDslTypes.COMMENT)

    override fun createFile(viewProvider: FileViewProvider) =
        object : PsiFileBase(viewProvider, HelloDslLanguage) {
            override fun getFileType() = HelloDslFileType
        }

    override fun createElement(node: ASTNode) = HelloDslTypes.Factory.createElement(node)
}
