package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.

Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream((s));
        int a = Integer.MAX_VALUE;
        int b;

        while (fileInputStream.read() > 0) {
            b = fileInputStream.read();
            if (b < a) a = b;
        }
        System.out.println(a);
        fileInputStream.close();
    }
}
