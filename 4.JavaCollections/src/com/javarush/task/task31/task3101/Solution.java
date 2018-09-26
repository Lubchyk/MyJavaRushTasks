package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Arrays;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File files = new File(args[0]);
        File allFilesContent = null;
        File resultFileAbsolutePath = new File(args[1]);
        if (FileUtils.isExist(resultFileAbsolutePath)) {
            allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        }
        if (FileUtils.isExist(files)) {
            File[] files1 = files.listFiles();
            Arrays.sort(files1);
            for (int i = 0; i < files1.length; i++) {
                if (files1[i].isFile() && files1[i].length() < 50) {
                    try (FileOutputStream outputstream = new FileOutputStream(allFilesContent, true);
                         FileInputStream fileInputStream = new FileInputStream(files1[i])) {

                        while (fileInputStream.available() != 0) {
                            outputstream.write(fileInputStream.read());
                        }
//                        outputstream.write("\n".getBytes());

                    } catch (IOException e) {

                    }
                }
            }
        }

    }
}
