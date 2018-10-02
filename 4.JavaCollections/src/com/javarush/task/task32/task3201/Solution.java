package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        long number = Long.parseLong(args[1]);
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        if (randomAccessFile.length() < number) number = randomAccessFile.length();
        randomAccessFile.seek(number);
        randomAccessFile.write(args[2].getBytes());
    }
}
