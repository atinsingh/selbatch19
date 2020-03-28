package co.pragra.learning.fullstackqa.b15framework.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class Config {
    // to hold properties
    private Properties properties;
    private final String CONFIG_FILE = "framework.properties";
    private static Config config;

    private Config()  {
        properties = new Properties();
        try {
            InputStream stream = new FileInputStream(Paths.get("src/test/resources",CONFIG_FILE).toFile());
            properties.load(stream);

        } catch (FileNotFoundException e) {
            System.out.println("Please check if your file "+ CONFIG_FILE + "exists in the directory src/test/resources");
            e.printStackTrace();
            System.exit(202);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key)  {
        if(config==null){
            config = new Config();
        }
        if(config.properties.getProperty(key)==null){
            throw new IllegalArgumentException("Key "+ key +" Doesn't exists in property file");
        }
        return config.properties.getProperty(key);

    }
}
