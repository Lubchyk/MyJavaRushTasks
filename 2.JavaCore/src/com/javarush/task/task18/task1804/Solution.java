package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

/**public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner( System.in );
        String s = scanner.nextLine();
        FileInputStream fileInputStream = new FileInputStream( (s) );
        int count = 1;
        Integer number = 0;
        int number2 = Integer.MAX_VALUE;
        String result = "";
        ArrayList<Integer> byteList = new ArrayList<Integer>();
        Map<Integer, Integer> list = new HashMap<>();

        while (fileInputStream.read() > 0) {
            byteList.add( fileInputStream.read() );
        }
        Collections.sort( byteList );
        for (int i = 0; i < byteList.size(); i++) {
            if ((i + 1) < byteList.size()) {
                if (byteList.get( i ).equals( byteList.get( i + 1 ))) {
                    count++;
                    number = byteList.get( i );
                    list.put( number, count );
                } else count = 1;
            }
            if (byteList.size() == 1) result = String.valueOf( byteList.get( 0 ) );
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = list.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator.next();
            if (pair.getValue() < number2) number2 = pair.getValue();
        }
        Iterator<Map.Entry<Integer, Integer>> iterator2 = list.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator2.next();
            if (pair.getValue() == number2) result = result + pair.getKey() + " ";
        }
        if(result.equals( "" )) {
            for (int i = 0; i < byteList.size(); i++) {
                result = result + byteList.get( i ) + " " ;
            }
            System.out.println(result.trim());
        }
        else System.out.println(result.trim());
        fileInputStream.close();
    } //"C:\\Users\\mlv\\Desktop\\Новая папка\\1.txt"
}*/
public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileInputStream inputStream = new FileInputStream(file);

        Map<Integer, Integer> map = new HashMap<>();

        while(inputStream.available() > 0){
            int x = inputStream.read();
            Integer frequency = map.get(x);
            map.put(x, frequency == null ? 1 : frequency + 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1)){
                System.out.print(entry.getKey() + " ");
            }
        }

        reader.close();
        inputStream.close();
    }
}
