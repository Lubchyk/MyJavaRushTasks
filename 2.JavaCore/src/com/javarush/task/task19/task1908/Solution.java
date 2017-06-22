package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1

Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedReader reader1 = new BufferedReader( new FileReader( reader.readLine() ) );
        BufferedWriter writer = new BufferedWriter( new  FileWriter(reader.readLine()) );

        String number = "";

        while (reader1.ready()) {
            int temp;
            char data = (char) reader1.read();
            try {
                temp = Integer.parseInt( String.valueOf( data ) );
                number += String.valueOf( temp );

            } catch (Exception e) {
                if (!(number.isEmpty())) {
                    writer.write( number );
                    writer.write( " " );
                    number = "";
                }
            }
        }
        reader.close();
        reader1.close();
        writer.close();
    }//C:/Users/ANT/Desktop/Нова папка (3)/1.txt
}
