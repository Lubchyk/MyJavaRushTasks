package com.javarush.task.task22.task2208;

import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* 
Формируем WHERE

{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder s = new StringBuilder("");
        String string = "";

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (Objects.nonNull(pair.getValue())) {
                s.append( string + pair.getKey() + " = '" + pair.getValue() + "'");
                string = " and ";
            }

        }
        return s.toString();
    }
}
