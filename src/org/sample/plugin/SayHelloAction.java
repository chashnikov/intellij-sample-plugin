package org.sample.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

/**
 * @author nik
 */
public class SayHelloAction extends AnAction {
  public void actionPerformed(AnActionEvent e) {
    Messages.showInfoMessage(e.getProject(), "Hello!", "Hello");
  }
}
