package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений — отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.
Пример байт входного файла:
44 83 44
Пример вывода:
44 83
Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        byte[] bit = new byte[0];
        while (inputStream.available() > 0 ) {
            bit = new byte[inputStream.available()];
            int b = inputStream.read(bit);
            Arrays.sort( bit );
            // C:\\Users\\mlv\\Desktop\\Новая папка\\1.txt
        }
        ArrayList<Byte> list = new ArrayList<>( );

        for (int i = 0; i < bit.length; i++) {
            list.add( bit[i] );
        }
        int count = 1;
        for (int i = 0; count < list.size();) {
            if (list.get( i ) == list.get( count )) {
                list.remove( i );
            }
            else {
                i++; count++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get( i ) + " ");
        }
        reader.close();
        inputStream.close();
    }
}
