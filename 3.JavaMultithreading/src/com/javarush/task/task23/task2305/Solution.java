package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solution = new Solution[2];
        Solution a = new Solution();
        Solution b = new Solution();
        a.innerClasses[0] = a.new InnerClass();
        a.innerClasses[1] = a.new InnerClass();
        b.innerClasses[0] = b.new InnerClass();
        b.innerClasses[1] = b.new InnerClass();
        solution[0] = a;
        solution[1] = b;
        return solution;
    }

    public static void main(String[] args) {

    }
}
