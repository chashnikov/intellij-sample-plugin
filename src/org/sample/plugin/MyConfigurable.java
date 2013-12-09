package org.sample.plugin;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author nik
 */
public class MyConfigurable implements Configurable {
  private final MyComponent myComponent;
  private JTextField myField;

  public MyConfigurable(MyComponent component) {
    myComponent = component;
  }

  @Nls
  @Override
  public String getDisplayName() {
    return "My Settings";
  }

  @Nullable
  @Override
  public String getHelpTopic() {
    return null;
  }

  @Nullable
  @Override
  public JComponent createComponent() {
    JPanel panel = new JPanel(new BorderLayout());
    myField = new JTextField();
    panel.add(myField, BorderLayout.NORTH);
    return panel;
  }

  @Override
  public boolean isModified() {
    return !myField.getText().trim().equals(myComponent.getState().name);
  }

  @Override
  public void apply() throws ConfigurationException {
    myComponent.getState().name = myField.getText().trim();
  }

  @Override
  public void reset() {
    myField.setText(myComponent.getState().name);
  }

  @Override
  public void disposeUIResources() {
  }
}
