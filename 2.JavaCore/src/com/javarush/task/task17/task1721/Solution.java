package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла — в allLines, из второго — в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
Требования:
1. Класс Solution должен содержать public static поле allLines типа List.
2. Класс Solution должен содержать public static поле forRemoveLines типа List.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
            BufferedReader   reader1 = new BufferedReader( new FileReader( bufferedReader.readLine() ));
            BufferedReader   reader2 = new BufferedReader( new FileReader( bufferedReader.readLine() ));


            while (reader1.ready()) allLines.add( reader1.readLine() );

            while (reader2.ready()) forRemoveLines.add( reader2.readLine() );


        try {
            s.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

            bufferedReader.close();
            reader1.close();
            reader2.close();

    }

    public void joinData() throws CorruptedDataException {
        boolean swich = true;
        for (int i = allLines.size() -1; i >= 0 ; i--) {
            System.out.println(i);
            for (int j = 0; j < forRemoveLines.size(); j++) {
                if (allLines.get( i ).equals( forRemoveLines.get( j ) )) {
                    allLines.remove( i );
                    //swich = false;
                }
            }
        }
        if (allLines.size()>0) {
//            for (int i = allLines.size()-1; i >= 0; i--) {
//                allLines.remove( i );
                allLines.removeAll( allLines );
           // }
            throw new CorruptedDataException();
        }


    }
    public void joinData1() throws IOException
    {
        if (allLines.containsAll (forRemoveLines))
            allLines.removeAll (forRemoveLines);
        else
        {
            allLines.clear ( );
            throw new CorruptedDataException ( );
        }
    }
}//C:/Users/ANT/Desktop/Нова папка (3)/1.txt
//C:/Users/ANT/Desktop/Нова папка (3)/2.txt
