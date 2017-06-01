package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        String[] temp = args[0].split("\\s+");
        FileInputStream inputStream = new FileInputStream( args[1] );
        FileOutputStream outputStream = new FileOutputStream( args[2] );


        if (temp[0].equals( "-e" )) {
            while (inputStream.available() > 0){
                int data = inputStream.read();
                outputStream.write( (data +1) );
            }
        }
        else if (temp[0].equals( "-d" )) {
                while (inputStream.available() > 0) {
                  int data = inputStream.read();
                  outputStream.write( (data -1) );
                }
        }
        inputStream.close();
        outputStream.close();

    }

}
