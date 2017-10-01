package com.javarush.task.task19.task1926;

import java.io.*;

/*
Перевертыши
1 Считать с консоли имя файла. Считать содержимое файла.

2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке.
2.2 вывести на экран.
3 Закрыть потоки.
Пример тела входного файла:
я - программист.
Амиго
Пример результата:
.тсиммаргорп - я
огимА
Требования:
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String addres = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(addres));
        while (reader1.ready()) {
            String line = reader1.readLine();
            String reverse = new StringBuffer(line).reverse().toString();
            System.out.println(reverse);
        }
        reader1.close();
    } //    /home/ant/New/22
}
