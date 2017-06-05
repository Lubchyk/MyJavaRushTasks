package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

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
    public static void main(String[] args) throws Exception {
        bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
        path = bufferedReader.readLine();

        if ( args.length > 0 && args[0].equals( "-c" )) {
            getMaxID();
            String fullName = String.format( "%-8d%-30s%-8s%-4s", (maxID + 1), args[1], args[2], args[3] );
            System.out.println( fullName );
            addToPriceList( fullName );
            bufferedReader.close();
        }
    }

    public static void addToPriceList(String fullName) throws Exception {
        outputStream = new FileOutputStream(path, true);
       // outputStream = new FileOutputStream("C:/Users/ANT/Desktop/1.txt", true);
        outputStream.write( 13 );
        outputStream.write( 10 );
        outputStream.write( fullName.getBytes() );
        outputStream.close();
    }

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
                   // System.out.println( maxID );
                    id = "";
                    swich = false;
                }
            }
        }
        inputStream.close();
    }


} // "C:/Users/ANT/Desktop/1.txt"   "-c" "SSSSS FFFFFFFF GGGG" "159.00" "12"