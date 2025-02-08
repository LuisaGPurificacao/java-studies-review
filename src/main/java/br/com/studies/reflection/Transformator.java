package br.com.studies.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

import static java.lang.Class.forName;

public class Transformator {

    public <I, O> O transform(I input) {
        try {
            Class<?> source = input.getClass();
            Class<?> target = forName(String.format("%s%s", source.getName(), "Dto"));

            O targetClass = (O) target.getDeclaredConstructor().newInstance();

            Field[] sourceFields = source.getDeclaredFields();
            Field[] targetFields = target.getDeclaredFields();

            Arrays.stream(sourceFields).forEach(sourceField -> {
                Arrays.stream(targetFields).forEach(targetField -> {
                        if (validateField(sourceField, targetField)) {
                            try {
                                targetField.set(targetClass, sourceField.get(input));
                            } catch (IllegalAccessException e) {
                                System.err.printf("%s: %s", "Error while setting fields", e.getMessage());
                                throw new RuntimeException("Error while setting fields");
                            }
                        }
                });
            });

            return targetClass;
        } catch (Exception e) {
            System.err.printf("%s: %s", "Error while trying to transform items", e.getMessage());
            throw new RuntimeException("Error while trying to transform items");
        }
    }

    private boolean validateField(Field source, Field target) {
        if (source.getName().equals(target.getName()) &&
                source.getType().equals(target.getType())) {
            source.setAccessible(true);
            target.setAccessible(true);
            return true;
        }
        return false;
    }

}
