package se.lexicon.tonygranath.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesManager {
    private static PropertiesManager INSTANCE;
    private Map<String, String> propertyMap = new HashMap<>();

    private PropertiesManager(Map<String, String> properties) {
        if (properties == null) {
            File file = new File("resources/settings.cfg");
            if (file.exists()) {
                read(file.getPath());
            }
        } else
            propertyMap = properties;
    }

    private PropertiesManager() {}

    public static PropertiesManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PropertiesManager(null);
        return INSTANCE;
    }

    public static PropertiesManager getTestInstance() {
        return new PropertiesManager(new HashMap<>());
    }

    public Map<String, String> getProperties() {
        return propertyMap;
    }

    public boolean save(String file) {
        Properties properties = new Properties();

        if (!propertyMap.isEmpty()) {
            for (Map.Entry<String, String> entry : propertyMap.entrySet()) {
                properties.putIfAbsent(entry.getKey(), entry.getValue());
            }

            try {
                Writer writer = new FileWriter(file);
                properties.store(writer, "");
                return true;
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void set(String property, String value) {
        propertyMap.put(property, value);
    }

    public void set(Map<String, String> properties) {
        for(Map.Entry<String, String> entry : properties.entrySet()) {
            if (propertyMap.putIfAbsent(entry.getKey(), entry.getValue()) != null)
                throw new RuntimeException("Property "+ entry.getKey() + "already set.");
        }
    }

    public void read(String file) {
        Properties properties = new Properties();

        try {
            properties.load(Files.newBufferedReader(Paths.get(file)));
            Set<String> propertyNames = properties.stringPropertyNames();
            clear();
            for(String key : propertyNames) {
                propertyMap.put(key, properties.getProperty(key));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        propertyMap.clear();
    }

    public void remove(String property) {
        propertyMap.remove(property);
    }

    public String get(String key) {
        return propertyMap.get(key);
    }
}
