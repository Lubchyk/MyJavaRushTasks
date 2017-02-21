package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        FileInputStream fileInputStream = new java.io.FileInputStream(sourceFileName);

        int s = 0;
        while (fileInputStream.available() > 0) {

            s = fileInputStream.read();
            System.out.print((char) s);
        }
        System.out.println();

        reader.close();
        fileInputStream.close();
//C:\Users\АНТ\Desktop\55.txt C:\Users\mlv\Desktop\55.txt
    }
}