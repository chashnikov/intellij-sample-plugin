package org.sample.plugin;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author nik
 */
public class MyRunConfiguration extends ModuleBasedConfiguration {
  public MyRunConfiguration(String name, RunConfigurationModule configurationModule, ConfigurationFactory factory) {
    super(name, configurationModule, factory);
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    element.setAttribute("value", "");
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    super.writeExternal(element);
  }

  @Override
  public Collection<Module> getValidModules() {
    return Arrays.asList(ModuleManager.getInstance(getProject()).getModules());
  }

  @NotNull
  @Override
  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    return new SettingsEditor<MyRunConfiguration>() {
      @Override
      protected void resetEditorFrom(MyRunConfiguration s) {

      }

      @Override
      protected void applyEditorTo(MyRunConfiguration s) throws ConfigurationException {
      }

      @NotNull
      @Override
      protected JComponent createEditor() {
        return new JTextField();
      }
    };
  }

  @Nullable
  @Override
  public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment env) throws ExecutionException {
    return null;
  }
}
