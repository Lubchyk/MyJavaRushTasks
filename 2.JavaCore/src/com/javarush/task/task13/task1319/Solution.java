package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String adress = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(adress));
        String line;
        for (; true ;) {
            line = reader.readLine();
            if (!line.equals("exit")) {
                writer.write(line);
                writer.newLine();
            }
            else {
                writer.write(line);
                break;
            }
        }
        reader.close();
        writer.close();
    }
}
