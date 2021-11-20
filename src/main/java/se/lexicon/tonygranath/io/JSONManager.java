package se.lexicon.tonygranath.io;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JSONManager {
    private static JSONManager INSTANCE;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static JSONManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new JSONManager();
        return INSTANCE;
    }

    public static JSONManager getTestInstance() {
        return new JSONManager();
    }

    private JSONManager() {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public <T> void serializeCollection(File file, Collection<T> collection) {
        try {
            objectMapper.writeValue(file, collection);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public <T> Collection<T> deserializeToCollection(File file, Collection<T> collection, Class<T> clazz) {
        if (collection == null)
            collection = new ArrayList<>();
        JavaType type = objectMapper.getTypeFactory().constructParametricType(Collection.class, clazz);

        try {
            collection = objectMapper.readValue(file, type);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return collection;
    }
}
