package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
*/

public class  Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);}

        try {
            throw  new ArithmeticException();
        } catch (ArithmeticException e) {
            exceptions.add(e);}

        try {
            throw  new ArrayStoreException();
        } catch (ArrayStoreException e) {
            exceptions.add(e);}

        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            exceptions.add(e);}

        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            exceptions.add(e);}

        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
            exceptions.add(e);}

        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            exceptions.add(e);}

        try {
            throw new NegativeArraySizeException();
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);}

        try {
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);}

        try {
            throw new ReflectiveOperationException();
        } catch (ReflectiveOperationException e) {
            exceptions.add(e);}

    }
}
