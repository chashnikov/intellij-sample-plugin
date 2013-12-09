package org.sample.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.Messages;

/**
 * @author nik
 */
public class SayHelloAction extends AnAction {
  public void actionPerformed(AnActionEvent e) {
    Module module = e.getData(LangDataKeys.MODULE);
    FileEditorManager.getInstance(getEventProject(e)).getSelectedEditors();
    ((MyComponent) MyComponent.getInstance(getEventProject(e))).getState().setEnabled(false);
    ModuleRootManager.getInstance(module).getContentRoots();
    Messages.showInfoMessage(e.getProject(), "Hello!", "Hello");
  }
}
