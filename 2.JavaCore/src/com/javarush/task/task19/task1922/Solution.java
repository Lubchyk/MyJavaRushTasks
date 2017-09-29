package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.
Пример:
words содержит слова А, Б, В
Строки:
В Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова — подходит, выводим
Требования:
1. Класс Solution должен содержать публичное статическое поле words типа List, которое должно быть сразу проинициализировано.
2. Класс Solution должен содержать статический блок, в котором добавляются три слова в список words.
3. Программа должна считывать имя файла с консоли (используй BufferedReader).
4. BufferedReader для считывания данных с консоли должен быть закрыт.
5. Программа должна считывать содержимое файла (используй FileReader).
6. Поток чтения из файла (FileReader) должен быть закрыт.
7. Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String address = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(address));

        while (reader1.ready()) {

            String line = reader1.readLine();
            String[] wordsFromFile = line.split(" ");
            if (checkLine(wordsFromFile)) {
                System.out.println(line);
            }
        }
        reader.close();
        reader1.close();
        reader.close();
    }
    public static boolean checkLine(String[] wordsFromFile) {
        int count = 0;
        for (int i = 0; i < wordsFromFile.length; i++) {
            for (int j = 0; j < words.size(); j++) {
                if (wordsFromFile[i].equals(words.get(j))) count++;
            }
        }
        switch (count) {
            case 2 : return true;
            default: return false;
        }
    } //C:\1.txt
}
