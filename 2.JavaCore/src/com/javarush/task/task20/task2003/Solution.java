package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static Properties properties1 = new Properties();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String q = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(q);
        load(fileInputStream);
        OutputStream outputStream = new FileOutputStream("/home/ant/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/properties.properties2");
        save(outputStream);

        //implement this method - реализуйте этот метод
    }

//    public void save(OutputStream outputStream) throws Exception {
//
//        Iterator<Map.Entry<String, String>> iterator = properties.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, String> pair = iterator.next();
//            outputStream.write((pair.getKey() + " = ").getBytes());
//            outputStream.write((pair.getValue() +  "\n").getBytes());
//
//        }
//        outputStream.flush();
//        outputStream.close();
//        //implement this method - реализуйте этот метод
//    }
public void save(OutputStream outputStream) throws Exception {
    //implement this method - реализуйте этот метод
    BufferedWriter br = new BufferedWriter(new OutputStreamWriter(outputStream));
    for (Map.Entry<String, String> p : properties.entrySet())
    {
        String key = p.getKey().replace(" ", "\\ ");
        String value = p.getValue().replace(System.lineSeparator(), "\\"+System.lineSeparator());
        br.write(key + " : " + value + System.lineSeparator());
    }
    br.flush();
    br.close();
}

    public void load(InputStream inputStream) throws Exception {
        properties1.load(inputStream);
        for (final String name: properties1.stringPropertyNames())
            properties.put(name, properties1.getProperty(name));
    }

    public static void main(String[] args) throws Exception {
//        fillInPropertiesMap();

    } ///home/ant/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2003/properties.properties
}
