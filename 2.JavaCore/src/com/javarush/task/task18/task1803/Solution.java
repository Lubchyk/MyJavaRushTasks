package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner( System.in );

        String s = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream( (s) );
        int count = 1;
        Integer number = 0;
        int number2 = 0;
        String s1 = "";
        ArrayList<Integer> byteList = new ArrayList<Integer>();
        Map<Integer, Integer> list = new HashMap<>();


        while (fileInputStream.read() > 0) {
            byteList.add( fileInputStream.read() );
        }
        Collections.sort( byteList );
        for (int i = 0; i < byteList.size(); i++) {
            if ((i + 1) < byteList.size()) {
                if (byteList.get( i ).equals( byteList.get( i + 1 ) )) {
                    count++;
                    number = byteList.get( i );
                    list.put( number, count );
                } else count = 1;
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = list.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator.next();
            if (pair.getValue() > number2) number2 = pair.getValue();
        }
        //System.out.println( number2 );

        Iterator<Map.Entry<Integer, Integer>> iterator2 = list.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> pair = iterator2.next();
            if (pair.getValue() == number2) s1 = s1 + pair.getKey() + " ";
        }
        System.out.println(s1.trim());
        fileInputStream.close();
    } //"C:\\Users\\mlv\\Desktop\\Новая папка\\1.txt"
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        //1. Ввести с консоли имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        //2. Найти байт или байты с максимальным количеством повторов.
        ArrayList<Byte> byteList = new ArrayList<>();
        while (fileInputStream.available() > 0){
            int data  = fileInputStream.read();// ВОТ поток FileInputStream читает файл, я не знаю что ещё можно тут предложить валидатору
            byteList.add((byte)data);
        }
        reader.close();
        //Делаем список с количеством повторений байтов на тех же индексах, что и в byteList
        ArrayList<Long> indexList = new ArrayList<>();
        long l = 0;//количество повторений конкретного байта - записываем в indexList
        for (int i = 0; i < byteList.size(); i++) {
            for ( Byte b : byteList ) {
                if (byteList.get(i) == b) {
                    l++;
                }
            }
            indexList.add(l);
            l = 0;
        }
        //узнаем самое большое количество совпадений
        ArrayList<Long> indexSort = new ArrayList<>(indexList);//массив для сортировки
        Collections.sort(indexSort);                           //сортируем по возрастанию
        long countSort = byteList.isEmpty() ? 0 : indexSort.get(indexSort.size() - 1);  //самое большое количество совпадений - последний элемент в массиве
        //добавляем  в список результат отбора
        ArrayList<Byte> finalBytes = new ArrayList<>();//для результатов
        for (int j = 0; j < indexList.size(); j++) {       //идём по списку с количествами совпадений (индексы в нём соответствуют начальному списку байтов byteList)
            if (indexList.get(j) == countSort){            //если число совпадений равно самому большому количеству совпадений
                if(!finalBytes.contains(byteList.get(j))){ //если в списке результатов ещё нет этого байта,
                    finalBytes.add(byteList.get(j));       //то добавить туда
                }
            }
        }
        //3. Вывести их на экран через пробел.
        for (int j = 0; j < finalBytes.size(); j++) {
            System.out.print(finalBytes.get(j) + " ");
        }
        //4. Закрыть поток ввода-вывода.
        fileInputStream.close();
    }
}*/