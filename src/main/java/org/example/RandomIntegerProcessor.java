package org.example;

import homework_2.Homework;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIntegerProcessor {
    public static void processRandomInteger(Object obj){
        for (Field declaredField : obj.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(RandomInteger.class)){
                RandomInteger annotation = declaredField.getAnnotation(RandomInteger.class);
                // if (annotation != null) можно делать проверку на существование аннотации
                // получили объект аннотации (конкретно нашей созданной)
                int min = annotation.min();  // получили значения параметров аннотации
                int max = annotation.max();  // получили значения параметров аннотации

                declaredField.setAccessible(true);
                try {
                    declaredField.set(obj, ThreadLocalRandom.current().nextInt(min, max));

                } catch (IllegalAccessException e) {
                    System.err.println("Не удалось подставить рандомное значение" + e);
                }
            }
        }
    }
}
