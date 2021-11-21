package se.lexicon.tonygranath.io;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class PropertiesManagerTest {
    private static final PropertiesManager PROPERTIES_DAO = PropertiesManager.getTestInstance();
    private static final String READ_CONFIG_FILE = "src/test/resources/test.config";
    private static final String SAVE_CONFIG_FILE = "src/test/resources/test_save.config";

    @Before
    public void setUp() {
        PROPERTIES_DAO.clear();
    }

    @Test
    public void getProperties() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
        PROPERTIES_DAO.set(testMap);
        assertEquals(PROPERTIES_DAO.getProperties(), testMap);
    }

    @Test
    public void save() {
        PROPERTIES_DAO.set("key", "value");
        assertTrue(PROPERTIES_DAO.save(SAVE_CONFIG_FILE));
    }

    @Test
    public void save_failed() {
        PROPERTIES_DAO.set("key", "value");
        assertFalse(PROPERTIES_DAO.save(""));
    }

    @Test
    public void set() {
        PROPERTIES_DAO.set("test", "value");
        assertTrue(PROPERTIES_DAO.getProperties().containsKey("test"));
    }

    @Test(expected = RuntimeException.class)
    public void set_throws_runtime_exception_on_duplicate_keys() {
        PROPERTIES_DAO.set("key", "value1");
        PROPERTIES_DAO.set("key", "value2");
    }

    @Test
    public void setMap() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("key1", "value1");
        testMap.put("key2", "value2");
        PROPERTIES_DAO.set(testMap);
        assertTrue(PROPERTIES_DAO.getProperties().containsKey("key1"));
        assertTrue((PROPERTIES_DAO.getProperties().containsKey("key2")));
        assertTrue(PROPERTIES_DAO.getProperties().containsValue("value1"));
        assertTrue(PROPERTIES_DAO.getProperties().containsValue("value2"));
    }

    @Test(expected = RuntimeException.class)
    public void setMap_throws_runtime_exception_on_duplicate_keys() {
        PROPERTIES_DAO.set("duplicate", "test");
        Map<String, String> testMap = new HashMap<>();
        testMap.put("duplicate", "value");
        PROPERTIES_DAO.set(testMap);
    }

    @Test
    public void read() {
        PROPERTIES_DAO.read(READ_CONFIG_FILE);
        assertTrue(PROPERTIES_DAO.getProperties().containsKey("key1"));
        assertTrue(PROPERTIES_DAO.getProperties().containsKey("key2"));
        assertTrue(PROPERTIES_DAO.getProperties().containsKey("key3"));
    }

    @Test
    public void clear() {
        PROPERTIES_DAO.set("key", "value");
        assertFalse(PROPERTIES_DAO.getProperties().isEmpty());
        PROPERTIES_DAO.clear();
        assertTrue(PROPERTIES_DAO.getProperties().isEmpty());
    }

    @Test
    public void remove() {
        PROPERTIES_DAO.set("key", "value");
        assertTrue(PROPERTIES_DAO.getProperties().containsKey("key"));
        PROPERTIES_DAO.remove("key");
        assertFalse(PROPERTIES_DAO.getProperties().containsKey("key"));
    }
}