package org.onlineLearning.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    public static void loadConfig()
    {
        try(InputStream input=ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties"))
        {
            if(input==null)
            {
                throw new RuntimeException("❌ config.properties file not found in classpath!");
            }
            properties.load(input);
            System.out.println("✅ Config file loaded successfully from classpath.");
        }
        catch (IOException e)
        {
            throw new RuntimeException("❌ Failed to load config.properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key)
    {
        if (properties.isEmpty()) {
            throw new RuntimeException("⚠️ Config file not loaded! Call loadConfig() before using getProperty().");
        }
        return properties.getProperty(key);
    }
}
