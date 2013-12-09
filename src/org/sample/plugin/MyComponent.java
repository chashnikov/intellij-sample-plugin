package org.sample.plugin;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.annotations.Attribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.serialization.PathMacroUtil;

/**
 * @author nik
 */
@State(name = "MyComponent",
 storages = {
     @Storage(file = StoragePathMacros.PROJECT_FILE),
     @Storage(file = StoragePathMacros.PROJECT_CONFIG_DIR + "/my-settings.xml", scheme = StorageScheme.DIRECTORY_BASED)
 }
)
public class MyComponent extends MyComponentInterface implements ProjectComponent,
    PersistentStateComponent<MyComponent.MyState> {
  private Project myProject;
  private MyService myService;
  private MyState myState = new MyState();

  public MyComponent(Project project, MyService service) {
    myProject = project;
    myService = service;
  }

  @Override
  public void projectOpened() {

  }

  @Nullable
  @Override
  public MyState getState() {
    return myState;
  }

  @Override
  public void loadState(MyState state) {
    myState = state;
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

  public static class MyState {
    public String name = "default";
    private boolean myEnabled = true;

    @Attribute("enabled")
    public boolean isEnabled() {
      return myEnabled;
    }

    public void setEnabled(boolean enabled) {
      myEnabled = enabled;
    }
  }
}
