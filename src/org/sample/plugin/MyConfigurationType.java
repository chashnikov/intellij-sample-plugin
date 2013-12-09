package org.sample.plugin;

import com.intellij.execution.configurations.*;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author nik
 */
public class MyConfigurationType extends ConfigurationTypeBase implements ConfigurationType {
  public MyConfigurationType() {
    super("my-run-configuration", "My Run", "", AllIcons.RunConfigurations.Tomcat);
    addFactory(new ConfigurationFactory(this) {
      @Override
      public RunConfiguration createTemplateConfiguration(Project project) {
        return new MyRunConfiguration("Untitled", new JavaRunConfigurationModule(project, false), this);
      }
    });
  }
}
