package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.

Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        int count = 0;

        while (reader1.ready()) {
            String s[] = reader1.readLine().split("[\\p{P} \\t\\n\\r]");

            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("world")) count++;
            }
        }
        System.out.println(count);
        reader.close();
        reader1.close();
    }//C:/Users/mlv/Desktop/Новая папка/1.txt
}
