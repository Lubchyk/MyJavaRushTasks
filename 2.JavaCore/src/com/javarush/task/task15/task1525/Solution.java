package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/* 
Файл в статическом блоке
1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по-отдельности в List lines.
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();


    static {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(Statics.FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data;
        while ((scanner.hasNext())) {
            data = scanner.nextLine();
            lines.add(data);
        }

    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
