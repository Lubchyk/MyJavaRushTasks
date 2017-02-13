package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        double sum = 0;
        for (; true; ) {
            int s = scanner.nextInt();
            if (s == -1) break;
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        sum = sum/ list.size();
        System.out.println(sum);
    }
}

