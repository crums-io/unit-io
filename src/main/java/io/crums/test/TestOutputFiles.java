/*
 * Copyright 2024 Babak Farhang
 */
package io.crums.test;


import java.io.File;

/**
 * Defines abstract file paths for output per class. Typically, these are used as a root
 * directories for the unit test, with dedicated subdirectories per unit test method, and
 * then subdirectories per each run of each method. 
 */
public class TestOutputFiles {
  
  public final static String TARGET = "target";
  public final static String TEST_OUTPUTS = "test-outputs";
  

  private final File root;
  
  
  public TestOutputFiles() {
    this(new File("."));
  }
  
  
  
  /**
   * 
   */
  public TestOutputFiles(File context) {
    if (!context.isDirectory())
      throw new IllegalArgumentException("context must be an existing directory: " + context);
    this.root = new File(context, TARGET + File.separator + TEST_OUTPUTS);
    if (!root.mkdirs() && !root.isDirectory())
      throw new IllegalArgumentException("failed to create test output directory " + root);
  }
  
  
  
  public File getOutputPath(Class<?> clazz) {
    if (clazz.isArray())
      throw new IllegalArgumentException(clazz.getName());
    return new File(root, clazz.getName());
  }

}
