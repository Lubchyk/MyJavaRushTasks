package com.javarush.task.task31.task3113;

import sun.dc.pr.PathStroker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/* 
Что внутри папки?
*/
public class Solution {
    static long size = 0;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String pathToFolder = scanner.nextLine();
        Path path = Paths.get(pathToFolder);

        if (Files.isDirectory(path)) {
            AtomicInteger directories = new AtomicInteger();
            AtomicInteger files = new AtomicInteger();
//            long size = Files.size(path);
            Files.walk(path)
                    .forEach(f -> {
                        if (Files.isDirectory(f)) directories.getAndIncrement();
                        else {
                            files.getAndIncrement();
                            try {
                               size += Files.size(f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

//            Files.list(path).filter(f -> Files.isRegularFile(f)).mapToLong(Files::size).sum();
//            long size = Files.walk(path).mapToLong( p -> p.toFile().length()).sum();
            System.out.println("Всего папок - " + (directories.get() - 1));
            System.out.println("Всего файлов - " + files);
            System.out.println("Общий размер - " + size);
        }
        else System.out.println(path.toString() + " - не папка"); // /home/ant/Desktop/root
    }
}
