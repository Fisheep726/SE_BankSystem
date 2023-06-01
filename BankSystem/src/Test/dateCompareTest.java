package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class dateCompareTest {
    public static void main(String[] args) throws ParseException {
        Date system = new Date();
        Date date = new Date(2023,5,10);
        Calendar date2 = Calendar.getInstance();
        date2.set(2023,5,10);

        System.out.println("system: " + system);
        System.out.println("date: " + date);
        System.out.println("date2: " + date2.getTime());
        System.out.println(system.after(date));
        System.out.println(system.before(date));
    }
}
