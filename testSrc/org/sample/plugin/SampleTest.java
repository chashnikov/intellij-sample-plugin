package org.sample.plugin;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.testFramework.ModuleTestCase;

/**
 * @author nik
 */
public class SampleTest extends ModuleTestCase {
  public void testCreate() {
    Module[] modules = ModuleManager.getInstance(myProject).getModules();
    assertEquals(1, modules.length);
  }
}
