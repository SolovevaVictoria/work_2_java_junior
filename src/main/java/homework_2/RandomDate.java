package homework_2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomDate {
    // TODO
    // UNIX timestamp - количество милисекунд, прошедших с 1 января 1970 года по UTC-0
    long min() default 1704067200000L; //01.01.2024
    // 1 января 2024 UTC-3
    long max() default 1735689600000L; //01.01.2025
}
