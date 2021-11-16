package se.lexicon.tonygranath.data;

import java.util.Map;

public interface PropertiesDAO {
    boolean save(String file);
    void set(String property, String value);
    void set(Map<String, String> properties);
    void read(String file);
    Map<String, String> getProperties();
    void clear();
    void remove(String property);
}
