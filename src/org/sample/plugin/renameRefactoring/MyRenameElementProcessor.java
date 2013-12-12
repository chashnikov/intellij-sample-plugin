package org.sample.plugin.renameRefactoring;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Created by anna on 12/12/13.
 */
public class MyRenameElementProcessor extends RenamePsiElementProcessor {
    @Override
    public boolean canProcessElement(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiField && ((PsiField) psiElement).getName().equals("myFooField");
    }

    @Override
    public void prepareRenaming(PsiElement element, String newName, Map<PsiElement, String> allRenames) {
        super.prepareRenaming(element, newName, allRenames);
        PsiClass containingClass = ((PsiField) element).getContainingClass();
        allRenames.put(containingClass, StringUtil.capitalizeWords(newName, true));
    }
    
    
}
