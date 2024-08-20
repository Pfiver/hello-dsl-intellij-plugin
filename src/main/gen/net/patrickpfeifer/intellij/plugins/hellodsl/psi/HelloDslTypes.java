// This is a generated file. Not intended for manual editing.
package net.patrickpfeifer.intellij.plugins.hellodsl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import net.patrickpfeifer.intellij.plugins.hellodsl.psi.impl.*;

public interface HelloDslTypes {

  IElementType KEY_VALUE = new HelloDslElementType("KEY_VALUE");

  IElementType COMMENT = new HelloDslElementType("COMMENT");
  IElementType CRLF = new HelloDslElementType("CRLF");
  IElementType KEY = new HelloDslElementType("KEY");
  IElementType SEPARATOR = new HelloDslElementType("SEPARATOR");
  IElementType VALUE = new HelloDslElementType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == KEY_VALUE) {
        return new HelloDslKeyValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
