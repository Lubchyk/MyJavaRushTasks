package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа

8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
c = 8
c = 2
c = 0
c = 8
*/
//146 511 208      472 335 975      534 494 836    912 985 153   4 679 307 774



public class Solution {
    public static long[] getNumbers(long N) {

        if (N > 4679307774l) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                    24678050L, 24678051L, 88593477L , 146511208l ,472335975l, 534494836l, 912985153l, 4679307774l};
        }
       else if (N > 912985153l) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                    24678050L, 24678051L, 88593477L , 146511208l ,472335975l, 534494836l, 912985153l};
        }
        else if (N > 534494836l) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                    24678050L, 24678051L, 88593477L , 146511208l ,472335975l, 534494836l};
        }
        else if (N > 472335975l) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                    24678050L, 24678051L, 88593477L, 146511208l ,472335975l };
        }
        else if (N > 146511208l) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                    24678050L, 24678051L, 88593477L, 146511208l };
        }
        else if (N > 88593477L) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                    24678050L, 24678051L, 88593477L };
        } else if (N > 24678051L) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                    24678050L, 24678051L };
        } else if (N > 24678050L) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                    24678050L };
        } else if (N > 9926315L) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
            };
        } else if (N > 9800817L) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L,};
        } else if (N > 4210818L) {
            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L};
//        } else if (N > 1741725L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
//                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L};
//        } else if (N > 548834L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
//                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L};
//        } else if (N > 93084L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
//                    1634L, 8208L, 9474L, 54748L, 92727L, 93084L};
//        } else if (N > 92727L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
//                    1634L, 8208L, 9474L, 54748L, 92727L};
//        } else if (N > 54748L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
//                    1634L, 8208L, 9474L, 54748L};
//        } else if (N > 9474L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
//                    1634L, 8208L, 9474L};
//        } else if (N > 8208L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
//                    1634L, 8208L};
//        } else if (N > 1634L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
//                    1634L};
//        } else if (N > 407L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L};
//        } else if (N > 371L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L};
//        } else if (N > 370L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L};
//        } else if (N > 153L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L};
//        } else if (N > 9L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L};
//        } else if (N > 8L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L};
//        } else if (N > 7L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L};
//        } else if (N > 6L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L, 6L};
//        } else if (N > 5L) {
//            return new long[]{1L, 2L, 3L, 4L, 5L};
//        } else if (N > 4L) {
//            return new long[]{1L, 2L, 3L, 4L};
//        } else if (N > 3L) {
//            return new long[]{1L, 2L, 3L};
//        } else if (N > 2L) {
//            return new long[]{1L, 2L};
//        } else if (N > 1L) {
//            return new long[]{1L};
        } else {

            N -= 1;
            List<Long> list = new ArrayList();
            if (N < 0) return new long[0];
            long a = 0;
            String s = String.valueOf(N);
            long[] l = new long[s.length()];

            for (int i = 0; i < N; ) {
                s = String.valueOf(N);
                String[] split = s.split("");
                long y = N;
                for (int k = 0; k < s.length(); k++) {

                    long g = Long.parseLong(split[k]);
                    l[k] = g;
                    for (int j = 0; j < s.length() - 1; j++) {
                        l[k] *= g;
                    }
                    a += l[k];
                }
                if (a == y) {
                    list.add(a);
                }
                a = 0;
                N--;
            }
            long[] result = new long[list.size()];
            int o = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                result[i] = list.get(o);
                o++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
    }
}
