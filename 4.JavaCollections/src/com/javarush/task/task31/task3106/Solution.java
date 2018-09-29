package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(
//                Arrays.asList(new FileInputStream(args[1]), new FileInputStream(args[2]),
//                        new FileInputStream(args[3]), new FileInputStream(args[4])))));
//
//
////        String[] paths = new String[args.length - 1];
////        System.arraycopy(args, 1, paths, 0, paths.length);
////        Arrays.sort(paths);
//        try (FileOutputStream out = new FileOutputStream(args[0], true)) {
//            byte[] bytes = new byte[1024];
////            for (int i = 0; i < paths.length; i++) {
////                try (FileInputStream inMainFiles = new FileInputStream(paths[i]);
////                     ZipInputStream zipIn = new ZipInputStream(inMainFiles)) {
//                    ZipEntry zipEntry = is.getNextEntry();
//                    while (zipEntry != null) {
//                        int len;
//                        while ((len = is.read(bytes)) > 0) {
//                            is.read(bytes);
//                            out.write(bytes, 0 , len);
//                            out.flush();
//                        }
//                        zipEntry = is.getNextEntry();
//                    }
//                    is.closeEntry();
//                }
//                is.close();
//            }
//        }

    }

    private void v2(String[] args) throws IOException {
        String[] paths = new String[args.length - 1];
        System.arraycopy(args, 1, paths, 0, paths.length);
        Arrays.sort(paths);
        try (FileOutputStream out = new FileOutputStream(args[0])) {
            byte[] bytes = new byte[1024];
            for (int i = 0; i < paths.length; i++) {
                try (FileInputStream inMainFiles = new FileInputStream(paths[i]);
                     ZipInputStream zipIn = new ZipInputStream(inMainFiles)) {
                    ZipEntry zipEntry = zipIn.getNextEntry();
                    while (zipEntry != null) {
                        int len;
                        while ((len = zipIn.read(bytes)) > 0) {
                            zipIn.read(bytes);
                            out.write(bytes, 0 , len);
                        }
                        zipEntry = zipIn.getNextEntry();
                    }
                    zipIn.closeEntry();
                }
            }
        }
    }
}
