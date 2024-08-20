package net.patrickpfeifer.intellij.plugins.hellodsl.psi

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.FlexLexer
import net.patrickpfeifer.intellij.plugins.hellodsl.HelloDslLexer

class HelloDslLexerAdapter() : FlexAdapter(object : FlexLexer {

    var hdl: HelloDslLexer = HelloDslLexer(null)

    override fun yybegin(initialState: Int) { hdl.yybegin(initialState) }
    override fun yystate() = hdl.yystate()
    override fun getTokenStart() = hdl.tokenStart
    override fun getTokenEnd() = hdl.tokenEnd
    override fun advance() = hdl.yylex()
    override fun reset(buffer: CharSequence, start: Int, end: Int, initialState: Int) {
        hdl.reset(buffer, start, end, initialState) }
})
