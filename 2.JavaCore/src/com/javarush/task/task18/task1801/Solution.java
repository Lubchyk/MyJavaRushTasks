package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream((s));

        ArrayList<Integer> byteList = new  ArrayList<Integer>();

        while (fileInputStream.available() > 0) {
            byteList.add(fileInputStream.read()) ;
        }
        fileInputStream.close();
        Collections.sort(byteList);
        System.out.println(byteList.get(byteList.size() - 1));

    }//"C:\\Users\\mlv\\Desktop\\Новая папка\\1.txt"
}
