package org.sample.plugin;

import com.intellij.openapi.project.Project;

/**
 * @author nik
 */
public abstract class MyComponentInterface {
  public static MyComponentInterface getInstance(Project project) {
    return project.getComponent(MyComponentInterface.class);
  }

  public abstract String getSetting();
}
