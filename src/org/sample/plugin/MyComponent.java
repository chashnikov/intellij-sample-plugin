package org.sample.plugin;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author nik
 */
public class MyComponent extends MyComponentInterface implements ProjectComponent {
  private Project myProject;
  private MyService myService;

  public MyComponent(Project project, MyService service) {
    myProject = project;
    myService = service;
  }

  @Override
  public void projectOpened() {

  }

  @Override
  public void projectClosed() {

  }

  @Override
  public void initComponent() {

  }

  @Override
  public void disposeComponent() {

  }

  @NotNull
  @Override
  public String getComponentName() {
    return "MyComponent";
  }

  @Override
  public String getSetting() {
    return "";
  }
}
