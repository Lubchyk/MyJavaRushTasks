package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file2);
        FileInputStream inputStream1 = new FileInputStream(file3);
        FileOutputStream outputStream1 = new FileOutputStream(file1, true);

        byte[] bit;// = new byte[0];
        int b = 0;
        while (inputStream.available() > 0 ) {
            bit = new byte[inputStream.available()];
            b = inputStream.read(bit);
            outputStream1.write( bit );
            // C:\\Users\\mlv\\Desktop\\Новая папка\\1.txt
        }
        while (inputStream1.available() > 0) {
            bit = new byte[inputStream1.available()];
            b = inputStream1.read(bit);
            outputStream1.write( bit );
        }
        reader.close();
        inputStream.close();
        inputStream1.close();
        outputStream1.close();

    }
}
