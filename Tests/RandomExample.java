import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

public class RandomExample {


    /** створює рандомну дату з допомогою  Math.random */
    public static Date getRandomDate(int startYear) {
        long year = startYear + (long) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar((int) year, month, day);
        return calendar.getTime();
    }
    /** створює рандомне число між from i to*/
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom.nextInt(from, to);
    }
    /** створює рандомне число між 0 i 1*/
    public static double getRandomDouble() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom.nextDouble();    }
    /** створює рандомне число в діапазоні n*/
    public static long getRandomLongBetween0AndN(long n) {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return current.nextLong(n);
    }


}
