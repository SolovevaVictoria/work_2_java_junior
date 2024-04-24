package homework_2;
import homework_2.RandomDateProcessor;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Homework {
    public static void main(String[] args) {
        DateClass dateClass = new DateClass();
        RandomDateProcessor.processRandomDate(dateClass);

        System.out.println("Date:");
        System.out.println(dateClass.getDateDate() + " ( 2024)");
        System.out.println(dateClass.getDateDate2() + " (1970 - 2024)");
        System.out.println("____________________________________________");

        System.out.println("LocalDate:");
        System.out.println(dateClass.getDateLocalDate() + " (2024)");
        System.out.println(dateClass.getDateLocalDate2() + " (1970 - 2024)");
        System.out.println("____________________________________________");

        System.out.println("LocalDateTime:");
        System.out.println(dateClass.getDateLocalDateTime() + " (2024)");
        System.out.println(dateClass.getDateLocalDateTime2() + " (1970 - 2024)");
        System.out.println("____________________________________________");

        System.out.println("Instant:");
        System.out.println(dateClass.getDateInstant() + " (2024)");
        System.out.println(dateClass.getDateInstant2() + " (1970 - 2024)");
        System.out.println("____________________________________________");
    }



private static class DateClass {
    @RandomDate
    private Date dateDate;
    @RandomDate(min = 0) // левая граница с 1970
    private Date dateDate2;

    @RandomDate
    private LocalDate dateLocalDate;
    @RandomDate(min = 0) // левая граница с 1970
    private LocalDate dateLocalDate2;

    @RandomDate
    private LocalDateTime dateLocalDateTime;
    @RandomDate(min = 0) // левая граница с 1970
    private LocalDateTime dateLocalDateTime2;

    @RandomDate
    private Instant dateInstant;
    @RandomDate(min = 0) // левая граница с 1970
    private Instant dateInstant2;



    public String getDateDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(dateDate);
    }
    public String getDateDate2() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(dateDate2);
    }

    public String getDateLocalDate() {
        DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localFormat.format(dateLocalDate);
    }
    public String getDateLocalDate2() {
        DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localFormat.format(dateLocalDate2);
    }

    public String getDateLocalDateTime() {
        DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localFormat.format(dateLocalDateTime);
    }
    public String getDateLocalDateTime2() {
        DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localFormat.format(dateLocalDateTime2);
    }

    public String getDateInstant() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
                .withZone(ZoneId.of("Europe/Moscow"));
        return formatter.format(dateInstant);
    }
    public String getDateInstant2() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
                .withZone(ZoneId.of("Europe/Moscow"));
        return formatter.format(dateInstant2);
    }
}
}