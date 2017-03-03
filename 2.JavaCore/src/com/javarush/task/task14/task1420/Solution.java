package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a ;
        int b ;

                a = Integer.parseInt(reader.readLine());
                if (a <= 0){ throw new NumberFormatException(); }
                b = Integer.parseInt(reader.readLine());
                if (b <= 0) { throw new NumberFormatException(); }
                int c;
                int d = 1;
                if (a > b) c = a;
                else c = b;
                for (int i = 2; i < c; i++) {
                    if (a % i == 0 && b % i == 0) d = i;
                }
                System.out.println(d);


    }
}
