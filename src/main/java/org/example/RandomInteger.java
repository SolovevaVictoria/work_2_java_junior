package org.example;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface RandomInteger {
    int min() default 0;  // параметры аннотации, default 0 значение по умолчанию

    int max() default 180;  // параметры аннотации

    // типы данных параметров аннотаций:
    // примитивные
    // Class
    // String
    // Enum
    // массивы всего вышеперечисленного ^

}
