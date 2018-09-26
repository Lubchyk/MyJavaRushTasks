package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileTree = new ArrayList<>();
        File files = new File(root);
        Queue<File> queue = new PriorityQueue<>();

        File[] listFiles = files.listFiles();

        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                queue.add(listFiles[i]);
            }
            else if (listFiles[i].isFile()) fileTree.add(listFiles[i].getAbsolutePath());
        }
        if (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                File file = queue.poll();
                if (file.isDirectory()) {
                    File[] tempListFiles = file.listFiles();
                    for (int i = 0; i < tempListFiles.length; i++) {
                        if (tempListFiles[i].isDirectory()) queue.add(tempListFiles[i]);
                        else if (tempListFiles[i].isFile()) fileTree.add(tempListFiles[i].getAbsolutePath());
                    }
                }
                else if (file.isFile()) fileTree.add(file.getAbsolutePath());

            }
        }
        return fileTree;

    }

    public static void main(String[] args) throws IOException {
        getFileTree("/home/ant/Desktop/root");
    }
}
