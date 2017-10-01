package com.javarush.task.task19.task1923;

import java.util.regex.*;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        Pattern pattern = Pattern.compile("[0-9]");
        Pattern pattern1 = Pattern.compile("-?\\d+");
        Matcher matcher;
        while (reader.ready()) {
            String line =reader.readLine();
            String[] arrWords = line.split(" ");
            String line2 = "";
            for (int i = 0; i < arrWords.length; i++) {
                matcher = pattern.matcher(arrWords[i]);
                if (matcher.find()) line2 += " " + arrWords[i];
            }
            if (!line2.isEmpty()) {
                System.out.println(line2);
                writer.write(line2);
            }
        }
        reader.close();
        writer.close();
    }
} //   /home/ant/New/11
