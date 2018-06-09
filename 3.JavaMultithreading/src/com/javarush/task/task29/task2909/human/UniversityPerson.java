package com.javarush.task.task29.task2909.human;

public class UniversityPerson extends Human{
    private University university;

    private University teacher;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public University getTeacher() {
        return teacher;
    }

    public void setTeacher(University teacher) {
        this.teacher = teacher;
    }
}
