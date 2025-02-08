package br.com.studies.reflection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectToJson {

    public String transform(Object object) {
        String result = null;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Class<?> classToBeTransformed = object.getClass();

        Map<String, Object> mapper = new HashMap<>();
        Arrays.stream(classToBeTransformed.getDeclaredFields()).collect(Collectors.toList()).forEach(
                field -> {
                    field.setAccessible(true);
                    String key = field.getName();
                    Object value = null;
                    try {
                        value = field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    mapper.put(key, value);
                }
        );
        try {
            result = objectMapper.writeValueAsString(mapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
