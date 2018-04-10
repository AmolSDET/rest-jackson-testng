package com.amol.testing.handlers;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by adeshmukh on 4/9/18.
 */
public class JsonMapper {

    ObjectMapper objectMapper;

    public <T> List<T> getListObjectFromString(String json, Class<T> cls) {
        objectMapper =  new ObjectMapper();
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, cls));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T getObjectFromString(String json, Class<T> cls) {
        objectMapper =  new ObjectMapper();
        try {
            return objectMapper.readValue(json, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> getListObjectFromFile(String path, Class<T> cls) {
        objectMapper =  new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), objectMapper.getTypeFactory().constructCollectionType(List.class, cls));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
