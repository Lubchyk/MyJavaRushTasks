package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Файлы и исключения
Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException,
вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();

Требования:
1. Программа должна считывать имена файлов с консоли.
2. Для каждого файла нужно создавать поток для чтения.
3. Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
4. После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
5. Потоки для чтения из файла должны быть закрыты.
6. Команду "System.exit();" использовать нельзя.
*/
public class Solution {
    public static void main(String[] args)  {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        List<FileInputStream> list = new ArrayList<>(  );
        String way = null;
        FileInputStream fileInputStream = null;
        while (true) {
            try {
                way = reader.readLine();
            } catch (IOException e) {
            }
            try {
                fileInputStream = new FileInputStream( way );
                list.add( fileInputStream );
            } catch (FileNotFoundException e) {
                System.out.println( way );
                try {
                    reader.close();
                } catch (IOException e1) {
                }
                try {
                    for (int i = 0; i < list.size(); i++) {
                        list.get( i ).close();
                    }
                } catch (IOException e1) {

                }
                break;
            }
        }
    }
}