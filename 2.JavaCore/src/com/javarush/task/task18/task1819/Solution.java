package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.

Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream( file1 );
        FileInputStream inputStream2 = new FileInputStream( file2 );
        FileOutputStream outputStream;
        byte[] b1;
        while (inputStream1.available() > 0) {
             b1 = new byte[inputStream1.available()];
             inputStream1.read(b1);
             System.out.println(b1);
             while (inputStream2.available() > 0) {
                byte[] b2 = new byte[inputStream2.available()];
                inputStream2.read(b2);
                outputStream = new FileOutputStream( file1 );
                outputStream.write( b2 );
                outputStream.write( b1 );
                outputStream.close();
            }
        }
        inputStream1.close();
        inputStream2.close();
        //C:\\Users\\mlv\\Desktop\\Новая папка\\1.txt
        //C:\\Users\\mlv\\Desktop\\Новая папка\\2.txt
    }
}
