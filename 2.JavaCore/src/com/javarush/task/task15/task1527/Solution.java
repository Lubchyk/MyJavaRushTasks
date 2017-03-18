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
/**мій варіант не пройшов варіант нижче пройшов*/
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
    static String s[];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String url = reader.readLine();
        copyUrl = url;
        start = copyUrl.indexOf(a);
        copyUrl = copyUrl.substring(start + 1);
        end = copyUrl.indexOf(b);
        String par1 = copyUrl.substring(0, end);
        if (par1.equalsIgnoreCase(d)) {
            value = aDouble(copyUrl);
        }

//        alert(copyUrl);
//        alert(par1);
        for (int i = 0; i < url.length(); i++) {
            if (copyUrl.contains(c)) {
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
                if (part.equalsIgnoreCase(d)) {
                    value = aDouble(copyUrl);
                }
            } else break;
            // alert(copyUrl);
        }
            alert(par1);
            if (s[0]!="") alert(s[0]);
            if (value!=0) alert(value);

    }
    public static double aDouble (String value) {
        int count = 0;
        pi = "";
            for (int j = 1; j < value.length(); j++) {
                try {
                    pi = pi + (value.substring(end + j, end + j + 1));
                } catch (Exception e) {
                }
                try {
                    Solution.value = Double.parseDouble(pi);
                    count++;
                } catch (Exception ee) {
                    break;
                }
            }
            if (count == 0) {
            s = value.split("=" );
            s = s[1].split("&");
            //System.out.println(s[0]);

        }
        return Solution.value;
        }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
/**import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.ArrayList;
 public class Solution {
 public static void main(String[] args) throws IOException {
 //add your code here
 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 String url = reader.readLine();
 reader.close();
 if(!url.isEmpty()) {
 ArrayList<Character> characters = new ArrayList<>();
 //разбираем всё на char выкидывая лишнее с начала ссылки до знака ?
 boolean ifParam = false;
 for (Character ch : url.toCharArray()) {
 if (ifParam) characters.add(ch);
 if (ch == '?') ifParam = true;
 }
 //разбиваем на первоначальные составные части типа: lvl=15
 //&
 //view и т.д.
 ArrayList<String> listOfParams = new ArrayList<>();
 String makeParam = "";
 for (int q = 0; q < characters.size(); q++) {
 if (characters.get(q) != '&') makeParam += characters.get(q);
 else {
 listOfParams.add(makeParam);
 listOfParams.add("&");
 makeParam = "";
 }
 if (q == characters.size() - 1) listOfParams.add(makeParam);
 }
 //разбиваем на составные части полностью
 //lvl
 //=
 //15
 // и т д.
 ArrayList<String> listOfParamsEnd = new ArrayList<>();
 String makeParamEnd = "";
 for (String st : listOfParams) {
 for (int c = 0; c < st.toCharArray().length; c++) {
 if (st.toCharArray()[c] != '=') makeParamEnd += st.toCharArray()[c];
 else {
 listOfParamsEnd.add(makeParamEnd);
 listOfParamsEnd.add("=");
 makeParamEnd = "";
 }
 if (c == st.toCharArray().length - 1) {
 listOfParamsEnd.add(makeParamEnd);
 makeParamEnd = "";
 }
 }
 }
 // генерим string параметров
 String resPar = listOfParamsEnd.get(0);
 for (int x = 2; x < listOfParamsEnd.size(); x++) {
 if (listOfParamsEnd.get(x).equals("=")) continue;
 if (listOfParamsEnd.get(x - 1).equals("=")) continue;
 if (listOfParamsEnd.get(x).equals("&")) continue;
 if (listOfParamsEnd.get(x - 1).equals("&")) resPar += " " + listOfParamsEnd.get(x);
 }
 System.out.println(resPar);
 // поиск объектов и вызов методов
 for (int x = 0; x < listOfParamsEnd.size(); x++) {
 if (listOfParamsEnd.get(x).equals("obj")) {
 try {
 double dobVal = Double.parseDouble(listOfParamsEnd.get(x + 2));
 alert(dobVal);
 } catch (NumberFormatException e) {
 alert(listOfParamsEnd.get(x + 2));
 }
 }
 }
 }
 }
 public static void alert(double value) {
 System.out.println("double " + value);
 }
 public static void alert(String value) {
 System.out.println("String " + value);
 }
 }*/