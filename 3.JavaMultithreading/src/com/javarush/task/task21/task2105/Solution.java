package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        if (this == o)
            return true;
        Solution n = (Solution) o;
        if (first != null ? !first.equals(n.first) : n.first != null)
            return false;
        return last != null ? last.equals(n.last) : n.last == null;
    }

    public int hashCode() {
        int a = first != null ? first.hashCode() : 0;
        a = 31 * a + (last != null ? last.hashCode() : 0);
        return a;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
