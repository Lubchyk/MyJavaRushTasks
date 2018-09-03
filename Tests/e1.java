import java.math.BigDecimal;

/**
 * Created by mlv on 05.07.2017.
 */
public class e1 {
    public static void main(String... args) {
        BigDecimal bigDecimal = new BigDecimal("651033883623.38");
        String s = bigDecimal.toString();
//        System.out.println(bigDecimal.toString());
        int value = 123_456_789;
//        System.out.println(value);
        double a  = 6510338836235555555555555555555555555555555555555555555555555.38d;
        BigDecimal g = new BigDecimal(a);
        int f = 999_999_999;

        System.out.println(a);
        System.out.println(g);
    }
}
