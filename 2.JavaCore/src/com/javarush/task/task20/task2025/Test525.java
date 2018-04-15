package com.javarush.task.task20.task2025;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Test525 {

    @Test
    public void test100() {
        long before = System.currentTimeMillis();
//        long l2 = Runtime.getRuntime().freeMemory();
        assertArrayEquals(Solution.getNumbers(7), new long[]{1L, 2L, 3L, 4L, 5L, 6L});
        assertArrayEquals(Solution.getNumbers(100), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L});
        assertArrayEquals(Solution.getNumbers(407), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L});
        assertArrayEquals(Solution.getNumbers(1000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L});
        assertArrayEquals(Solution.getNumbers(100000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                1634L, 8208L, 9474L, 54748L, 92727L, 93084L});
        assertArrayEquals(Solution.getNumbers(100000000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                24678050L, 24678051L, 88593477L});

//        long after = System.currentTimeMillis();
//        long l3 = Runtime.getRuntime().freeMemory();
//        long l6 = Runtime.getRuntime().totalMemory();
//        System.out.println(((l6 - l3) / 1048576) + " mb "  + ((after - before) / 1000d) + " sec");
    }
}
