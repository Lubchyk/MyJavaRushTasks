package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.
Объяви переменную типа список строк и сразу проинициализируй ee.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>(10);

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextLine());
        }
        String min = list.get(0);
        String max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (min.length() > list.get(i).length()) min = list.get(i);
            if (max.length() < list.get(i).length()) max = list.get(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(max)) {
                System.out.println(list.get(i));
                break;
            }
            if (list.get(i).equals(min)) {
                System.out.println(list.get(i));
                break;
            }
        }
    }
}
