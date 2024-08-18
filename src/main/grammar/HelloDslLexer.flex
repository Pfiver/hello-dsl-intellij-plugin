package net.patrickpfeifer.intellij.plugins.myfirstintellijplugin;

import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.*;
import static net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.psi.HelloDslTypes.*;

%%

%public
%class HelloDslLexer
%type IElementType

%state YYINITIAL
%state AWAIT_VALUE

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%%

<YYINITIAL> {
    {WHITE_SPACE}+                              {                         return WHITE_SPACE; }
    {END_OF_LINE_COMMENT}                       {                         return COMMENT; }
    {KEY_CHARACTER}+                            {                         return KEY; }
    {SEPARATOR}                                 { yybegin(AWAIT_VALUE);   return SEPARATOR; }
}

<AWAIT_VALUE> {
    {WHITE_SPACE}+                              {                         return WHITE_SPACE; }
    {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL);     return VALUE; }
    {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL);     return WHITE_SPACE; }
}

({CRLF}|{WHITE_SPACE})+                         { yybegin(YYINITIAL);     return WHITE_SPACE; }

[^]                                             {                         return BAD_CHARACTER; }
