package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Objects;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        String name = file.getName();
        int i = 0;
        String format = null;
        try {
            i = name.lastIndexOf(".");

        } catch (StringIndexOutOfBoundsException e) {
            ExceptionHandler.log(e);
        }
        if (i != 0 && i != -1) {
            format = name.substring(i);
        }
        if (file.isDirectory()) {
            if (Objects.nonNull(format)) {
                if (format.equalsIgnoreCase(".html") || format.equalsIgnoreCase(".htm")) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
