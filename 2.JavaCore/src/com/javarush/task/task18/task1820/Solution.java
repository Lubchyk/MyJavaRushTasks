package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.
Принцип округления:
3.49 — 3
3.50 — 4
3.51 — 4
-3.49 — -3
-3.50 — -3
-3.51 — -4
Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);


        byte[] b = null;
        int data = 0;
        while (inputStream.available() > 0) {
            b = new byte[inputStream.available()];
            data = inputStream.read(b);
        }
        int count = 0;
        boolean swich = true;
        ArrayList<String> s = new  ArrayList<String>();
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 32 && b[i] != 13 && b[i] != 10) {
                if (swich) {
                    s.add( count, String.valueOf( ((char) b[i]) ) );
                    swich = false;
                }
                else s.set( count, s.get( count ) + String.valueOf( ((char) b[i]) ) );
            }
            else {
                if (!swich) count++;
                swich = true;
            }
        }
        double[] doubles = new double[s.size()];
        int[] result = new int[s.size()];
        for (int i = 0; i < s.size(); i++) {
            doubles[i] = Double.parseDouble( s.get( i ) );
            result[i] = (int) Math.round( doubles[i] );
            String f = String.valueOf( result[i] );
            outputStream.write( (f + " ").getBytes() );

        }
        //C:\\Users\\mlv\\Desktop\\Новая папка\\1.txt
        //C:\\Users\\mlv\\Desktop\\Новая папка\\2.txt
        inputStream.close();
        outputStream.close();

    }
}
