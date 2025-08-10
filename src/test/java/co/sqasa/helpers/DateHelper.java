package co.sqasa.helpers;

import java.time.LocalDate;

public class DateHelper {


    public static String getCurrentDate(int day) {
        LocalDate date = LocalDate.now();
        return String.format("%d/%d/%d",
                date.getMonthValue(), day, date.getYear());
    }

    public static String getNextMonthDate(int day) {
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        return String.format("%d/%d/%d",
                nextMonth.getMonthValue(), day, nextMonth.getYear());
    }


}
