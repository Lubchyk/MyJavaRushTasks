package com.javarush.task.task18.task1817;

/* 
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.
Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
4. Выведенное значение необходимо округлить до 2 знаков после запятой.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**public class Solution {

   public static FileInputStream fileInputStream;

    public static void main(String[] args) throws IOException {
        fileInputStream = new FileInputStream( args[0] );
        int date;
        int count = 0;
        char c;
        Pattern pattern = Pattern.compile( "[\\s]" );
        Matcher matcher;

        while (fileInputStream.available() > 0) {
            date = fileInputStream.read();
            c = (char) date;
            matcher = pattern.matcher( String.valueOf( c ) );
            if (matcher.matches()) count++;
        }
        double f = (double) count/args[0].length() * 100;
        //System.out.printf("%.2f", f);
        System.out.println(String.format("%.2f",f));
        fileInputStream.close();


    }
}*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        int spaceCount = 0;
        double result;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            count++;
            if (data == 32) {
                spaceCount++;
            }
        }
        result = (double) spaceCount/count * 100;
        System.out.println(String.format("%.2f",result));
        fileInputStream.close();
    }
}
