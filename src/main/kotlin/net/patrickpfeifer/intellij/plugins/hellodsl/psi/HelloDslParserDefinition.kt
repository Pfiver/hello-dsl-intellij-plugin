package net.patrickpfeifer.intellij.plugins.hellodsl.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import net.patrickpfeifer.intellij.plugins.hellodsl.HelloDslFileType
import net.patrickpfeifer.intellij.plugins.hellodsl.HelloDslLanguage
import net.patrickpfeifer.intellij.plugins.hellodsl.HelloDslParser

class HelloDslParserDefinition : ParserDefinition {

    override fun getFileNodeType() = IFileElementType(HelloDslLanguage)
    override fun getStringLiteralElements() = TokenSet.EMPTY
    override fun getCommentTokens() = TokenSet.create(HelloDslTypes.COMMENT)

    override fun createParser(project: Project) = HelloDslParser()
    override fun createLexer(project: Project) = HelloDslLexerAdapter()

    private val helloDslFileType = HelloDslFileType()
    override fun createFile(viewProvider: FileViewProvider) =
        object : PsiFileBase(viewProvider, HelloDslLanguage) {
            override fun getFileType() = helloDslFileType
        }

    override fun createElement(node: ASTNode) = HelloDslTypes.Factory.createElement(node)
}
