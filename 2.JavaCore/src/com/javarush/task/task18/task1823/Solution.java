package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.

Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        while (true) {
            String way = reader.readLine();
            if (way.equals("exit")) break;
            else {
                ReadThread thread = new ReadThread( way );
                thread.start();
                thread.join();
            }
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
       private String way;
        FileInputStream fileInputStream;
        List<Integer> listBytes = new ArrayList<>(  );

        public ReadThread(String fileName) {
            this.way = fileName;
        }
        @Override
        public void run() {
            try {
                fileInputStream = new FileInputStream(way);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    listBytes.add( data );
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Collections.sort( listBytes );
            for (int i = 0; i < listBytes.size(); i++) {
                System.out.println(listBytes.get( i ));
            }
            int count = 1;
            int maxNumber = 0;
            int bytes = 0;
            for (int i = 0; i < listBytes.size(); i++) {
                if ( (i + 2) > listBytes.size()) break;
                if ( listBytes.get( i ) == listBytes.get( i + 1 )) {
                    count++;
                }
                else {
                    if (count > maxNumber) {
                    maxNumber = count;
                    bytes = listBytes.get( i );
                }
                count = 1;
                }
            }
            resultMap.put( way, bytes );
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // C:\\Users\\mlv\\Desktop\\Новая папка\\1.txt
    }
}
