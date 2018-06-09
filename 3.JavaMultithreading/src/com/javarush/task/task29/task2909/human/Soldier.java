package com.javarush.task.task29.task2909.human;

public class Soldier extends Human implements Alive{
    private boolean isSoldier;

    public Soldier(String name, int age) {
        super(name, age);
        this.isSoldier = true;

    }

    public void live() {
        if (isSoldier)
            this.fight();
    }

    public void fight() {
    }


    public boolean isSoldier() {
        return isSoldier;
    }

    public void setSoldier(boolean soldier) {
        isSoldier = soldier;
    }
}
