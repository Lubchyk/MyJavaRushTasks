package com.javarush.task.task22.task2211;

//import java.io.*;
import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки

Charset koi8 = Charset.forName("KOI8-R");
Charset windows1251 = Charset.forName("Windows-1251");

byte[] buffer = new byte[1000];
inputStream.read(buffer);
String s = new String(buffer, koi8);
buffer = s.getBytes(windows1251);
outputStream.write(buffer);
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        File file2 = new File(args[1]);

        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file2);

        byte[] buffer = new byte[1000];

        while (inputStream.read(buffer) > 0) {
            String s = new String( buffer, "Windows-1251");
            buffer = s.getBytes("UTF-8");
            outputStream.write(buffer);
        }
    }
}
