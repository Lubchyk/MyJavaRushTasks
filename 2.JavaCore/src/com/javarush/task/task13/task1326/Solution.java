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

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        //FileReader fileReader = new FileReader(reader.readLine());
        //FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<>();
        String line;
        int data;
        while ((line = reader1.readLine()) != null) {
            data = Integer.parseInt(line);
            list.add(data);
            //System.out.println(data);
        }
        reader.close();
        reader1.close();
        //fileReader.close();
        int temp;
        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.size(); j++) {
                if (list.size() < i + 1) break;
                if (list.get(i) > list.get(i + 1)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }



    } //C:\Users\mlv\Desktop\55.txt

}
