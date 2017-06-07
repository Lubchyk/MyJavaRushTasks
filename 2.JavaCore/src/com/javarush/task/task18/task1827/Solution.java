package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины.
Пример:
19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234
Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
4. Товар должен иметь следующий id, после максимального, найденного в файле.
5. Форматирование новой строки товара должно четко совпадать с указанным в задании.
6. Созданные для файлов потоки должны быть закрыты.
*/
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
        if ( args.length > 0 && args[0].equals( "-c" )) {
            path = bufferedReader.readLine();
            getMaxID();
            fullName = String.format( "%-8d%-30s%-8s%-4s", (maxID + 1), args[1], args[2], args[3] );
            BufferedReader reader = new BufferedReader( new FileReader(path));
            list = new ArrayList<>();
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            reader.close();
            list.add(fullName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
                writer.write("\r\n");
            }
            writer.close();
            bufferedReader.close();
        }
    }
//    public static void addToPriceList(String fullName) throws Exception {
//        outputStream = new FileOutputStream(path, true);
//        outputStream.write( 13 );
//        outputStream.write( 10 );
//        outputStream.write( fullName.getBytes() );
//        outputStream.close();
//    }
    public static void getMaxID() throws Exception {
        inputStream = new FileInputStream(path);
        boolean swich = true;
        while (inputStream.available() > 0 ){
            char data = (char) inputStream.read();
            if (data == 10) {
                swich = true;
                continue;
            }
            if (swich) {
                try {
                    int number = Integer.parseInt( String.valueOf( data ) );
                    id = id + number;
                } catch (Exception e) {
                    if (maxID < Integer.parseInt( id )) maxID = Integer.parseInt( id );
                    id = "";
                    swich = false;
                }
            }
        }
        inputStream.close();
    }
} // "C:/Users/ANT/Desktop/1.txt"    C:/Users/mlv/Desktop/Новая папка/1.txt  "-c" "SSSSS FFFFFFFF GGGG" "159.00" "12"





/**import java.io.*;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) throws Exception {
//           Reading fileName
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String line;
        if (args.length == 0) return;
        if (args[0].equals("-c")) {
//          Searching max id
            reader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> array = new ArrayList<String>();
            int id;
            line = reader.readLine();
            array.add(line);
            int idmax = -1;
            if (line == null) idmax = 0;
            else {
                idmax = Integer.parseInt(line.substring(0, 8).trim()); //first Id
                while ((line = reader.readLine()) != null) {
                    array.add(line);
                    id = Integer.parseInt(line.substring(0, 8).trim());
                    if (id > idmax) idmax = id;
                }
            }
            reader.close();
//           Create formatted String result
            String price = args[args.length - 2];
            String quantity = args[args.length - 1];
            int idPrice;
            StringBuilder productName = new StringBuilder();
            productName.append(args[1]);
            for (int i = 2; i < args.length - 2; i++) productName.append(" " + args[i]);
            String result = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", ++idmax, productName, price, quantity);
            array.add(result);
//          Writing into the file
            BufferedWriter  writer = new BufferedWriter(new FileWriter(fileName));
            for (String s : array)  {
                writer.write(s);
                writer.write(System.lineSeparator());
            }
            writer.close();
        }
    }
}*/