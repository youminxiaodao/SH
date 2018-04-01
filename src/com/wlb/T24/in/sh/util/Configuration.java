package com.wlb.T24.in.sh.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration
  implements Constants
{
  public static Properties getProperites()
  {
    File file = new File("field.properties");
    Properties properties = new Properties();
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(file);
      properties.load(fis);
    }
    catch (Exception e) {
    	System.out.println("Get [field.properties] failed!");
      Closer.close(new Closeable[] { 
        fis }); } finally { Closer.close(new Closeable[] { 
        fis });
    }
    return properties;
  }

}