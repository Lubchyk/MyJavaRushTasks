package com.javarush.task.task18.task1828;

/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id — 8 символов
productName — название товара, 30 chars (60 bytes)
price — цена, 8 символов
quantity — количество, 4 символа
-u — обновляет данные товара с заданным id
-d — производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины
Пример:
19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static FileOutputStream outputStream;
    static FileInputStream inputStream;
    static BufferedReader bufferedReader;
    static String path;
    static String id = "";
    static int maxID;
    static String fullName;
    static List<String> list;
    public static void main(String[] args) throws Exception {
        bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
        if (args.length == 0) return;
        if ( args.length > 0 && args[0].equals( "-d" )) {
            path = bufferedReader.readLine();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            list = new ArrayList<>();
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            reader.close();
            getMaxID(args[1], 1);
        }
        else if (args.length > 0 && args[0].equals( "-u" )) {
            path = bufferedReader.readLine();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            list = new ArrayList<>();
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            reader.close();
            fullName = String.format( "%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4] );
            getMaxID(args[1], 2);
        }
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
                writer.write("\r\n");
            }
            writer.close();
            bufferedReader.close();
    }
    public static void getMaxID(String curId, int q) throws Exception {
        boolean swich = true;
        int index = 0;
        int d = 0;
            while (swich) {
                try {
                    for (int i = d; i < list.size(); ) {
                     String s = String.valueOf(list.get(i).charAt(index));
                        int number = Integer.parseInt(s);
                        id +=number;
                        index++;
                    }
                } catch (Exception e) {
                    if (curId.equals(id)) {
                        swich = false;
                        if (q == 1) list.remove(d);
                        if (q == 2) {
                            list.add(d, fullName);
                            list.remove(d + 1);
                        }
                    }
                    else {
                        index = 0;
                        d++;
                        id = "";
                    }
                }
            }
        }
} // "C:/Users/ANT/Desktop/1.txt"    C:/Users/mlv/Desktop/Новая папка/1.txt  "-c" "SSSSS FFFFFFFF GGGG" "159.00" "12"
