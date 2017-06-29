package com.javarush.task.task19.task1916;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/* 
Отслеживаем изменения
Считать с консоли 2 имени файла — file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.
Пример:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка5            ADDED строка5
строка4         строка4            SAME строка4
строка5                            REMOVED строка5

Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов,
где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
*/

/**public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(reader.readLine()));
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (bufferedReader1.ready()) {
            list1.add(bufferedReader1.readLine());
        }
            while (bufferedReader2.ready()) {
                list2.add(bufferedReader2.readLine());
            }
        for (int i = 0; i < list1.size(); i++) {
            boolean truee = true;
            if (list1.get(i).equals(list2.get(i))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                truee = false;
            }
            else if (!list1.get(i).equals(list2.get(i))) {
                for (int j = 0; j < list2.size(); j++) {
                    if (list1.get(i).equals(list2.get(j))) {
                        if (i > j) {
                            lines.add(new LineItem(Type.SAME, list1.get(i)));
                            truee = false;
                        } else {
                            lines.add(new LineItem(Type.ADDED, list2.get(i)));
                            truee = false;
                        }
                    }
                }
            }
            if (truee)lines.add(new LineItem(Type.REMOVED, list1.get(i)));
        }
        for (int i = 1; i < list2.size(); i++) {
            boolean falsee = false;
            for (int j = 0; j < list2.size(); j++) {
                if (list2.get(i).equals(list1.get(j))) {
                    falsee = true;
                    break;
                }
            }
            if (!falsee)lines.add(i+1, new LineItem(Type.ADDED, list2.get(i)));
        }
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i).line + " " + lines.get(i).type);
        }

        reader.close();
        bufferedReader1.close();
        bufferedReader2.close();
    }
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

    }

}//C:/Users/mlv/Desktop/Новая папка/2.txt*/

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine(), file2 = reader.readLine();
        reader.close();

        BufferedReader inputFile1 = new BufferedReader(new FileReader(file1));
        BufferedReader inputFile2 = new BufferedReader(new FileReader(file2));

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (inputFile1.ready()) {
            list1.add(inputFile1.readLine());
        }

        while (inputFile2.ready()) {
            list2.add(inputFile2.readLine());
        }

        inputFile1.close();
        inputFile2.close();

        while (list1.size() > 0 | list2.size() > 0) {
            if (list1.size() > 0 && list2.size() > 0) {

                if (list1.get(0).equals(list2.get(0))) {
                    lines.add(new LineItem(Type.SAME, list1.get(0)));
                    list1.remove(0);
                    list2.remove(0);
                } else if (!list1.get(0).equals(list2.get(0)) && !list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                } else if (!list1.get(0).equals(list2.get(0)) && list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                }
            } else if (list1.size() > 0 && list2.isEmpty()) {
                for (int i = 0; i < list1.size(); i++) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    list1.remove(0);
                }
            } else if (list1.isEmpty() && list2.size() > 0) {
                for (int i = 0; i < list2.size(); i++) {
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    list2.remove(0);
                }
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + " " + line;
        }
    }
}