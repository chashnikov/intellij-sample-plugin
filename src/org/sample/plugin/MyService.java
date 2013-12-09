package org.sample.plugin;

import com.intellij.openapi.components.ServiceManager;

/**
 * @author nik
 */
public abstract class MyService {
  public static MyService getInstance() {
    return ServiceManager.getService(MyService.class);
  }

  public abstract boolean compute();
}
