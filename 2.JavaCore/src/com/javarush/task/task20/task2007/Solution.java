package com.javarush.task.task20.task2007;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Как сериализовать JavaRush?
*/
public class Solution {
    public static class JavaRush implements Serializable{
        public List<User> users = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof JavaRush)) return false;
            JavaRush javaRush = (JavaRush) o;
            return Objects.equals(users, javaRush.users);
        }

        @Override
        public int hashCode() {

            return Objects.hash(users);
        }
    }

    public static void main(String[] args) {

    }
}
