package com.javarush.task.task19.task1925;

import java.io.*;

/*
Длинные слова
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.
Пример выходных данных в файл2:
длинное,короткое,аббревиатура
Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line2 = "";
        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6) line2 += words[i] + ",";
            }
        }
        line2 = line2.substring(0,line2.length() - 1);
        System.out.println(line2);
        writer.write(line2);
        reader.close();
        writer.close();
    }
}
