package org.sample.plugin;

import com.intellij.openapi.Disposable;

/**
 * @author nik
 */
public class MyServiceImpl extends MyService implements Disposable {
  @Override
  public boolean compute() {
    return false;
  }

  @Override
  public void dispose() {

  }
}
