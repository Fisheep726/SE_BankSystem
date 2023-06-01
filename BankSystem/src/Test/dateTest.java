package Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateTest {
    public static void main(String[] args) {
//        Date now = new Date();
//        Date set = new Date();
//
//        System.out.println(now);
//        System.out.println(set);
//
//        System.out.println();
//        System.out.println(now.getYear());
//        System.out.println(set.getYear());
//        System.out.println();
//        System.out.println(now.before(set));
//        System.out.println(now.compareTo(set));

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Calendar set = Calendar.getInstance();
        set.set(2023,5,12);
        Calendar check = Calendar.getInstance();
        check.set(2023,5,14);


        System.out.println();
        System.out.println("now: " + now.getTime());
        System.out.println();
        System.out.println("set: " + set.getTime());
        System.out.println();
        System.out.println("check: " + check.getTime());
        System.out.println();
        System.out.println(set.before(check));
        System.out.println(set.after(check));
        System.out.println();
        System.out.println(set.before(now));
        System.out.println(set.after(now));
        System.out.println();
        System.out.println(check.before(now));
        System.out.println(check.after(now));

    }
}
