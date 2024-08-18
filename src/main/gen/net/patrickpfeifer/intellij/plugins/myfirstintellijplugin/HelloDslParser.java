// This is a generated file. Not intended for manual editing.
package net.patrickpfeifer.intellij.plugins.myfirstintellijplugin;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static net.patrickpfeifer.intellij.plugins.myfirstintellijplugin.psi.HelloDslTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class HelloDslParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return helloDslFile(b, l + 1);
  }

  /* ********************************************************** */
  // item*
  static boolean helloDslFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "helloDslFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "helloDslFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // key_value|COMMENT|CRLF
  static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    r = key_value(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // (KEY? SEPARATOR VALUE?) | KEY
  public static boolean key_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value")) return false;
    if (!nextTokenIs(b, "<key value>", KEY, SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE, "<key value>");
    r = key_value_0(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY? SEPARATOR VALUE?
  private static boolean key_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key_value_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && key_value_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY?
  private static boolean key_value_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_0_0")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean key_value_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

}
