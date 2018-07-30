package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketAddress;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public ConsoleHelper() {
    }

    public static void writeMessage(String message ) {
        System.out.println(message);
    }
    public static String readString() {
     for (; ;) {
         try {
             return bufferedReader.readLine();
         } catch (IOException e) {
             writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
             readString();
         }
     }
    }
    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }
}
