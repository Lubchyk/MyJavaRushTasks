package com.javarush.task.task19.task1920;
/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.
Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        List<String> list = new ArrayList<>();

        while (reader.ready()) {
          String line = reader.readLine();
          String[] data = line.split("\\s+");
          if (map.containsKey(data[0])) {
              double temp = map.get(data[0]) + Double.parseDouble(data[1]);
              map.put(data[0], temp);
          }
          else map.put(data[0], Double.parseDouble(data[1]));
        }
        double maxMoney = Double.MIN_VALUE;
        String winer = "";

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > maxMoney) {
                winer = pair.getKey();
                maxMoney = pair.getValue();
            }
            else if (pair.getValue() == maxMoney) winer += " " + pair.getKey();
        }
        System.out.println(winer);
        reader.close();
    }
}
