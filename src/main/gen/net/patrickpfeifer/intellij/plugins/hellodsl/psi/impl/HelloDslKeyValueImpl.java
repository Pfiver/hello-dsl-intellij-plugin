// This is a generated file. Not intended for manual editing.
package net.patrickpfeifer.intellij.plugins.hellodsl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static net.patrickpfeifer.intellij.plugins.hellodsl.psi.HelloDslTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import net.patrickpfeifer.intellij.plugins.hellodsl.psi.*;

public class HelloDslKeyValueImpl extends ASTWrapperPsiElement implements HelloDslKeyValue {

  public HelloDslKeyValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HelloDslVisitor visitor) {
    visitor.visitKeyValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HelloDslVisitor) accept((HelloDslVisitor)visitor);
    else super.accept(visitor);
  }

}
