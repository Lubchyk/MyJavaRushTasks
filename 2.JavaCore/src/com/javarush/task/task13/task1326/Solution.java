package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
11
3
2
10

Пример вывода:
2
8
10
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2= new BufferedReader(new InputStreamReader(new FileInputStream(br1.readLine())));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));

        List<Integer> list = new ArrayList<>();
        String line;
        int data;
        while ((line = br2.readLine()) != null) {
            data = scanner.nextInt();
            list.add(data);
        }
        int temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
            System.out.println(list.get(i));
        }




//        br1.close();
//        br2.close();
        reader.close();
        scanner.close();

    } //C:\Users\mlv\Desktop\55.txt C:\Users\АНТ\Desktop\55.txt
}
