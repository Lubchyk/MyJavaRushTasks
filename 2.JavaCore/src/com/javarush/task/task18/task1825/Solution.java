package com.javarush.task.task18.task1825;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        Map<Integer, BufferedReader> map = new HashMap<>(  );
       // FileOutputStream outputStream;
        File file;
        String tempLine;
        String path = null;
        int index = 0;
        while (true) {
            tempLine  = reader.readLine();
            if (tempLine.equals( "end" )) {
                reader.close();
                break;
            }
            else {
                index = tempLine.lastIndexOf( '.' );
                //int path = tempLine.lastIndexOf( "\\" );
                int d = Integer.parseInt( tempLine.substring( index + 5));
                map.put( d, new  BufferedReader( new FileReader( tempLine ) ) );
                path = tempLine;
            }
        }
        //if (!new File( path.substring( 0, path.lastIndexOf( '/' ) ), path.substring( path.lastIndexOf( '/' ), index ) ).exists())new File( path.substring( 0, path.lastIndexOf( '/' ) ), path.substring( path.lastIndexOf( '/' ), index ) ).createNewFile();
        file = new File( path.substring( 0, path.lastIndexOf( '/' ) ), path.substring( path.lastIndexOf( '/' ), index ) );
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter( new FileWriter( file.getAbsoluteFile(), true ) )  ;    // outputStream = new FileOutputStream( file.getAbsoluteFile(), true );
        int count = 1;
        for (int i = 0; i < map.size() ;  ) {
            try {
                if (map.get( count ).ready()) writer.write( map.get( count ).read() );
                else {
                    i++;
                    count++;
                }
            } catch (Exception e) {
                count++;
                continue;
            }
        }
        writer.close();
        Iterator<Map.Entry<Integer, BufferedReader>> iterator = map.entrySet().iterator();
        for (Map.Entry<Integer, BufferedReader> pair : map.entrySet()) {
            pair.getValue().close();
        }
    }


        /**BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List< String > list = new ArrayList<>();
        String currentFile = "";
        String directory = "";
        String fileName = "";
        while (!"end".equals(currentFile = reader.readLine())) list.add(currentFile);
        reader.close();
        Collections.sort(list);
        int lastIndexDirectory = list.get(0).lastIndexOf('/'); //ищем индекс последнего вхождения косой черты
        int lastIndexFileName = list.get(0).lastIndexOf('.');//ищем индекс последнего вхождения точки
        directory = list.get(0).subSequence(0, lastIndexDirectory+1).toString();//выдёргиваем подстроку директории
        fileName = list.get(0).subSequence(lastIndexDirectory+1, lastIndexFileName).toString();//выдёргиваем подстроку файла (можно было в одну переменную выдернуть директорию и имя, но так нагляднее)

        FileOutputStream fos = new FileOutputStream(directory+fileName);
        if (!new File(directory+fileName).exists())new File(directory+fileName).createNewFile();

        for (String s: list ){
            FileInputStream fis = new FileInputStream(s);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            fos.write(buffer);
        }
        fos.close();*/




} //C:\\Users\\mlv\\Desktop\\Новая папка\\Lion.avi.part1;
//C:/Users/mlv/Desktop/Новая папка/Lion.avi.part1
