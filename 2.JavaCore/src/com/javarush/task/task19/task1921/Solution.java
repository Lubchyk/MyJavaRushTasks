package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List,
которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String name = "";
            String birthday = "";
            String line = reader.readLine();
            String[] s = line.split("\\s+");
            for (int i = 0; i < s.length; i++) {
                try {
                    Integer.parseInt(s[i]);
                    birthday += s[i] + "/";
                    birthday += s[i + 1] + "/";
                    birthday += s[i + 2] + "/";
                    new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse("15/04/1990");
                    PEOPLE.add(new Person(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday)));
                    break;
                } catch ( Exception e ) {
                    name += s[i]; // "  "
                }
                try {
                    if (i + 1 < s.length) Integer.parseInt(s[i + 1]);
                }catch ( Exception e ) {
                    name += " ";
                }
            }
        }
        reader.close();

//        for (int i = 0; i < PEOPLE.size(); i++) {
//            System.out.println(PEOPLE.get(i).toString());
//        }

    }
}
