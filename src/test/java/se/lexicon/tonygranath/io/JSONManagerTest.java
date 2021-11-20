package se.lexicon.tonygranath.io;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class JSONManagerTest {
    private static final String OUTPUT_FILE = "src/test/resources/test_serialize.json";
    private static final String INPUT_FILE = "src/test/resources/test_deserialize.json";
    private static final JSONManager TEST_INSTANCE = JSONManager.getTestInstance();
    private Collection<String> testCollection;

    @Test
    public void serializeCollection() {
        testCollection = new HashSet<>();
        testCollection.add("test1");
        testCollection.add("test2");
        testCollection.add("test3");
        TEST_INSTANCE.serializeCollection(new File(OUTPUT_FILE), testCollection);
    }

    @Test
    public void deserializeToCollection() {
        testCollection = new ArrayList<>();
        testCollection = TEST_INSTANCE.deserializeToCollection(new File(INPUT_FILE), testCollection, String.class);
        testCollection.forEach(System.out::println);
    }
}