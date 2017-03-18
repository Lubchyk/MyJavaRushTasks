package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово «exit«.
2. Для каждого значения, кроме «exit«, вызвать метод print. Если значение:
2.1. содержит точку ‘.‘, то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше нуля или больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <String> list = new ArrayList <>();
        for (; true; ) {
            String a = reader.readLine();
            if (a.equals("exit")) break;
            else list.add(a);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(".")) {
                try {
                    print(Double.parseDouble(list.get(i)));
                    continue;
                } catch (Exception e) {
                }
            } else {
                try {
                    int b = Integer.parseInt(list.get(i));
                    if (b > 0 && b < 128) { print((short) b);
                    continue;
                    }
                    else if (b <= 0 || b >= 128)  {
                        print(b);
                        continue;
                    }
                } catch (Exception e) {
                }
            }
            print(list.get(i));
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
