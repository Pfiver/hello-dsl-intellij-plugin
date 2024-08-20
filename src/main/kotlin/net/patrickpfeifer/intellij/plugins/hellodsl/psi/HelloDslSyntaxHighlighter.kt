package net.patrickpfeifer.intellij.plugins.hellodsl.psi

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

val SEPARATOR = createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
val KEY = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD)
val VALUE = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
val COMMENT = createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
val BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

class HelloDslSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer() = HelloDslLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return arrayOf(
            when (tokenType) {
                HelloDslTypes.SEPARATOR -> SEPARATOR
                HelloDslTypes.KEY -> KEY
                HelloDslTypes.VALUE -> VALUE
                HelloDslTypes.COMMENT -> COMMENT
                TokenType.BAD_CHARACTER -> BAD_CHARACTER
                else -> return emptyArray<TextAttributesKey>()
            }
        )
    }
}

class HelloDslSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?) = HelloDslSyntaxHighlighter()
}
