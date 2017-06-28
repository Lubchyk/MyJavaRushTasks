package com.javarush.task.task19.task1918;

/*
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.
Пример:
Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, «span«.
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, n, r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>
Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>
text1, text2 могут быть пустыми


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        FileReader reader1 = new FileReader( reader.readLine() ) ;
        BufferedReader reader2 = new BufferedReader( reader1 );
        List<String> list = new ArrayList<>(  );

        while (reader2.ready()) {
           String line = reader2.readLine();
           if (line.contains( "<" + args[0] )) {
               list.add( line );
           }
           else if (line.contains( "</" + args[0] )) list.add( line );
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get( i ));
        }
        reader.close();
        reader1.close();
        reader2.close();


    }//C:/Users/ANT/Desktop/Нова папка (3)/4.html
}
