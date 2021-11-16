package se.lexicon.tonygranath.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesDAOManager implements PropertiesDAO {
    private static final PropertiesDAOManager INSTANCE;
    private final Map<String, String> propertyMap = new HashMap<>();

    static {
        INSTANCE = new PropertiesDAOManager();
    }

    private PropertiesDAOManager() {}

    public static PropertiesDAOManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Map<String, String> getProperties() {
        return propertyMap;
    }

    @Override
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

    @Override
    public void set(String property, String value) {
        if (propertyMap.putIfAbsent(property, value) != null)
            throw new RuntimeException("Property "+ property + " already set.");
    }

    @Override
    public void set(Map<String, String> properties) {
        for(Map.Entry<String, String> entry : properties.entrySet()) {
            if (propertyMap.putIfAbsent(entry.getKey(), entry.getValue()) != null)
                throw new RuntimeException("Property "+ entry.getKey() + "already set.");
        }
    }

    @Override
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

    @Override
    public void clear() {
        propertyMap.clear();
    }

    @Override
    public void remove(String property) {
        propertyMap.remove(property);
    }
}
