package com.javarush.task.task32.task3202;

import java.io.*;
import java.util.Objects;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (Objects.isNull(is)) return writer;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
        while (bufferedInputStream.available() > 0) {
            int read = bufferedInputStream.read();
            writer.write(read);
        }
        return writer;
    }
}