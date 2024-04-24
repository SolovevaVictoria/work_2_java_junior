package homework_2;

import org.example.RandomInteger;

import java.lang.reflect.Field;
import java.sql.Date;
import java.time.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateProcessor {
    private static final long DAY_MLSESONDS = 86400000L; // 1000 * 60 * 60 * 24 количество миллисекунд в сутках
    private static final long SECOND_MLSC = 1000; // количество миллисекунд в секунде
    public static void processRandomDate(Object obj){
        for (Field declaredField : obj.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(RandomDate.class)){
                RandomDate annotation = declaredField.getAnnotation(RandomDate.class);
                // if (annotation != null) можно делать проверку на существование аннотации
                // получили объект аннотации (конкретно нашей созданной)
                long min = annotation.min();  // получили значения параметров аннотации
                long max = annotation.max();  // получили значения параметров аннотации

                declaredField.setAccessible(true);
                try {
                    if(declaredField.getType().isAssignableFrom(Date.class)){
                        declaredField.set(obj, new Date(ThreadLocalRandom.current().nextLong(min, max)));
                    }
                    else if (declaredField.getType().isAssignableFrom(LocalDate.class)){
                        // ofEpochDay(), который возвращает дату, отсчитанную от 1 января 1970 года. Общий вид такой:
                        // LocalDate date = LocalDate.ofEpochDay(день);
                        //  берём случайное количество миллисекунд, просшедших с ...1970 года (внутри 2024) - это наша рандомная дата, 
                        //  но нам нужен именно номер дня (отсчет от 1970), 
                        //  тогда общее число миллисекунд (с ...1970 года) и делим на кол-во миллисекунд в 1 сутках
                        declaredField.set(obj, LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(min, max) / DAY_MLSESONDS));
                    } else if (declaredField.getType().isAssignableFrom(LocalDateTime.class)) {
                        //
                        //public static LocalDateTime ofEpochSecond(long epochSecond, int nanoOfSecond, ZoneOffset offset)
                        //epochSecond − количество секунд от 1970-01-01T00:00:00Z
                        //nanoOfSecond − the nanosecond within the second, from 0 to 999,999,999
                        //offset − the zone offset, not null
                        declaredField.set(obj, LocalDateTime.ofEpochSecond(ThreadLocalRandom.current().nextLong(min, max) / SECOND_MLSC, 0, ZoneOffset.ofHours(3)));
                    } else if (declaredField.getType().isAssignableFrom(Instant.class)) {
                        declaredField.set(obj, Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong(min, max)));
                    }

                } catch (IllegalAccessException e) {
                    System.err.println("Не удалось подставить рандомную дату" + e);
                }
            }
        }
    }
}
