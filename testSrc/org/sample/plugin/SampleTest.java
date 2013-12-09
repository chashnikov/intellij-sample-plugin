package org.sample.plugin;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.testFramework.ModuleTestCase;

/**
 * @author nik
 */
public class SampleTest extends ModuleTestCase {
  public void testModules() {
    Module[] modules = ModuleManager.getInstance(myProject).getModules();
    MyComponentInterface instance = MyComponentInterface.getInstance(myProject);
    MyService service = MyService.getInstance();
    assertFalse(service.compute());
    assertEquals("", instance.getSetting());
    assertEquals(1, modules.length);

    MyExtension[] extensions = MyExtension.EP_NAME.getExtensions();
    for (MyExtension extension : extensions) {

    }
  }
  public void testModules2() {
    Module[] modules = ModuleManager.getInstance(myProject).getModules();
    assertEquals(0, modules.length);
  }
}
