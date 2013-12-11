package org.sample.plugin.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.JavaRecursiveElementWalkingVisitor;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nik
 */
public class MyFoldingBuilder extends FoldingBuilderEx {
  @NotNull
  @Override
  public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
    final List<FoldingDescriptor> descriptors = new ArrayList<FoldingDescriptor>();
    root.accept(new JavaRecursiveElementWalkingVisitor() {
      @Override
      public void visitMethod(PsiMethod method) {
        PsiAnnotation[] annotations = method.getModifierList().getAnnotations();
        for (PsiAnnotation annotation : annotations) {
          if (annotation.getQualifiedName().equals("my.SystemAnnotation")) {
            descriptors.add(new FoldingDescriptor(annotation, annotation.getTextRange()));
          }
        }
      }
    });
    return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
  }

  @Nullable
  @Override
  public String getPlaceholderText(@NotNull ASTNode node) {
    return "system annotation";
  }

  @Override
  public boolean isCollapsedByDefault(@NotNull ASTNode node) {
    return true;
  }
}
