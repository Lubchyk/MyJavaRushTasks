package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(args[0], "rw");
        long number = Long.parseLong(args[1]);
        byte[] line = new byte[args[2].getBytes().length];
        file.seek(number);
        int read = file.read(line, 0, line.length);
        String s = new String(line);

        file.seek(file.length());
        if (s.equals(args[2])) file.write("true".getBytes());
        else file.write("false".getBytes());
    }
}
