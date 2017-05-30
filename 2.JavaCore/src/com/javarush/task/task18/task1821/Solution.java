package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром — именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).
Пример:
‘,’=44, ‘s’=115, ‘t’=116.
Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.
Пример вывода:
, 19
- 7
f 361
Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new TreeMap<>(  );
        FileInputStream fileInputStream = new FileInputStream( args[0] );
        boolean swich = true;

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            char chars = (char) data;
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                if (pair.getKey().equals( String.valueOf( chars ))) {
                    map.put( String.valueOf( chars ), map.get( String.valueOf( chars )) + 1 );
                    swich = false;
                    break;
                }
                else swich = true;
            }
            if (swich) map.put( String.valueOf( chars ), 1 );
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();

            System.out.println( pair.getKey() + " " + pair.getValue());
        }

        fileInputStream.close();
    }
}
