package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
    }
    public static void sum(int a, int b, int c, int d) {
        int max = a;
        int temp;
        if (b > a) max = b;
        if (c > d) temp = c;
        else temp = d;
        if (max < temp) max = temp;
        System.out.println(max);

    }



}
