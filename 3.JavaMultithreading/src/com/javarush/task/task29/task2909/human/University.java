package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class University {
    private String name;
    private int age;

    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double v) {
        for (int i = 0; i < students.size(); i++) {
            if (v == students.get(i).getAverageGrade()) return students.get(i);
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        return students.stream().max((r1, r2) -> Double.compare(r1.getAverageGrade(), r2.getAverageGrade())).get();
    }

    public Student getStudentWithMinAverageGrade() {
        return students.stream().min((r1, r2) -> Double.compare(r1.getAverageGrade(), r2.getAverageGrade())).get();

    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}