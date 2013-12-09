package org.sample.plugin;

import com.intellij.openapi.extensions.ExtensionPointName;

/**
 * @author nik
 */
public interface MyExtension {
  public static final ExtensionPointName<MyExtension> EP_NAME = ExtensionPointName.create("org.intellij.samplePlugin.MyExtension");

  String getName();
}
