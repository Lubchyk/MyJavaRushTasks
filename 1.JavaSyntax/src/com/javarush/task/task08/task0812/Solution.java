package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        int length = 1;
        int count = 0;
        int number1 = list.get(0);
        int number2;
        for (int i = 1; i < list.size(); i++) {
            number2 = list.get(i);
            if (number1 == number2) {
                if (count == 0) count = 2;
                else count++;
            }
            else  {
                number1 = number2;
                if (length < count) length = count;
                count = 0;
            }
        }
        if (length < count) length = count;
        else if (count == 10) length = count;
        System.out.println(length);
    }
}