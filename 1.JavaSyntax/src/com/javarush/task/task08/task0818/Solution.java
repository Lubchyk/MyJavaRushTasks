package com.javarush.task.task08.task0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() throws IOException {
        HashMap<String,Integer> map = new HashMap<>();
            map.put("asfs", 800);
            map.put("sffdfsd", 900);
            map.put("awe", 500);
            map.put("eff", 600);
            map.put("fgd", 550);
            map.put("eqfgv", 750);
            map.put("wer", 900);
            map.put("plk", 1000);
            map.put("rkg", 400);
            map.put("gkkg", 1500);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500) iterator.remove();
        }
    }

    public static void main(String[] args) throws IOException {
        removeItemFromMap(createMap());

    }
}