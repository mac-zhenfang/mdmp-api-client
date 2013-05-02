package com.mdmp.client.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

/**
 * Configuration from user defined
 *
 * @author Denny Ye
 * @since 2012-11-20
 * @version 1.0
 */
public class Context {
  
  private static Properties prop = new Properties();
  
  static {
    //load default property file
    loadPropertiesFile("/api.properties");
    loadPropertiesFile("/app.properties");
    loadPropertiesFile("/report.properties");
    //loadPropertiesFile("/rawdata.properties");
//    loadPropertiesFile("/table.properties");
//    loadPropertiesFile("/di.properties");
//    loadPropertiesFile("/job.properties");
//    loadPropertiesFile("/migration.properties");
//    loadPropertiesFile("/flumeproxy.properties");
  }
  
  private static void loadPropertiesFile(String file) {
    FileInputStream input = null;
    try {
      URL uri = Context.class.getResource(file);
      String path = uri.getPath();
      File fileName = new File(path);
      input = new FileInputStream(fileName);
      
      prop.load(input);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  /**
   * Obtains value by specified key
   * 
   * @param key
   * @return might be null if this key is absent
   */
  public static String get(String key) {
    return prop.getProperty(key);
  }
  
  /**
   * @param key
   * @param defaultValue
   * @return
   */
  public static String get(String key, String defaultValue) {
    return prop.getProperty(key, defaultValue);
  }
  
  /**
   * Designed for API to obtains URL path except HTTP method
   * <br>
   * e.g : key.url = POST:/a/b/c
   * getUrl("key.url") = "/a/b/c"
   * getMethod("key.url") = "POST"
   * 
   * @param key
   * @return
   */
  public static String getUrl(String key) {
    String value = prop.getProperty(key);
    if (value != null) {
      String[] parts = value.split(":");
      if (parts.length == 2) {
        return parts[1];
      }
    }
    
    throw new IllegalArgumentException("key:" + key + ", value:" + value 
        + ". expect format <METHOD>:<url>");
  }
  
  public static String getMethod(String key) {
    String value = prop.getProperty(key);
    if (value != null) {
      String[] parts = value.split(":");
      if (parts.length == 2) {
        return parts[0];
      }
    }
    
    throw new IllegalArgumentException("key:" + key + ", value:" + value 
        + ". expect format <METHOD>:<url>");
  }
  
  public static Set<Object> getAllKeys() {
    return prop.keySet();
  }
  
}


