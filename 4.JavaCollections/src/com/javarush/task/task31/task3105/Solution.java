package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/*
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        try(FileInputStream inMainFiles = new FileInputStream(args[1]);
            ZipInputStream zipIn = new ZipInputStream(inMainFiles);
            FileInputStream inAdditionalFile = new FileInputStream(args[0]);
            FileOutputStream out = new FileOutputStream(args[1] + "1" );
            ZipOutputStream zipOut = new ZipOutputStream(out)) {
            ZipEntry entry;

            while ((entry = zipIn.getNextEntry()) != null) {
                zipOut.putNextEntry(new ZipEntry(entry.getName()));
                for (int c = zipIn.read(); c != -1; c = zipIn.read()) {
                    zipOut.write(c);
                }
                out.flush();
                zipIn.closeEntry();
            }
            ZipEntry zipEntry = new ZipEntry("new" + args[0].substring(args[0].lastIndexOf("/")));
            zipOut.putNextEntry(zipEntry);
            for (int c = inAdditionalFile.read(); c != -1; c = inAdditionalFile.read()) {
                zipOut.write(c);
            }
            zipOut.flush();
        }
        Files.move(Paths.get(args[1] + "1"), Paths.get(args[1]), REPLACE_EXISTING);
    }
}
