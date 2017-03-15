package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) — для чисел (дробные числа разделяются точкой)
alert(String value) — для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.
*/

public class Solution {

    static String copyUrl;
    static String a = "?";
    static String b = "=";
    static String c = "&";
    static String d = "obj";
    static String e = " ";
    static String pi = "";
    static int separator1;
    static int separator2;
    static int start;
    static int end;
    static double value = 0;
    static String part;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String url = reader.readLine();
        copyUrl = url;
        start = copyUrl.indexOf("?");
        copyUrl = copyUrl.substring(start + 1);
        end = copyUrl.indexOf("=");
        String par1 = copyUrl.substring(0, end);


        if (par1.equalsIgnoreCase("obj")) {
            value = aDouble(copyUrl);
        }

//        alert(copyUrl);
//        alert(par1);
        for (int i = 0; i < url.length(); i++) {
            if (copyUrl.contains("&")) {
                start = copyUrl.indexOf(c);
                copyUrl = copyUrl.substring(start + 1);
                try {
                    separator1 = copyUrl.indexOf(b);
                } catch (Exception ee) {
                    separator1 = Integer.MAX_VALUE;
                }
                try {
                    separator2 = copyUrl.indexOf(c);
                } catch (Exception ee) {
                    separator2 = Integer.MAX_VALUE;
                }

                if (separator1 > separator2 && separator2 > 0) end = separator2;
                else end = separator1;
                part = copyUrl.substring(0, end);
                par1 = par1 + e + part;
                if (part.equalsIgnoreCase("obj")) {
                    value = aDouble(copyUrl);
                }
            } else break;
            // alert(copyUrl);
        }
            alert(par1);
            if (value!=0) alert(value);

    }
    public static double aDouble (String value) {

            for (int j = 1; j < value.length(); j++) {
                pi = pi.concat(value.substring(end + j, end + j + 1));
                try {
                    Solution.value = Double.parseDouble(pi);
                } catch (Exception ee) {
                    break;
                }
            } return Solution.value;
        }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
