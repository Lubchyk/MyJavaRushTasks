package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 20; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        SecureRandom random = new SecureRandom();
        String result = "";
        String letter = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String specChars = "!@#$%^&*_=+-/";
        String dic = letter + number + letter.toUpperCase();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(dic.length());
            result += dic.charAt(index);
        }
        outputStream.write(result.getBytes());
        return outputStream;
    }
}