package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlv on 21.06.2017.
 */
public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List getHorses() {
        return horses;
    }

    public Hippodrome(List horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {

        game = new Hippodrome(new ArrayList());

        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }

    public void run(){

        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    public Horse getWinner() {
        double temp;
        double maxDistance = 0;
        for (int i = 0; i < horses.size(); i++) {
           temp = horses.get(i).getDistance();
           if (temp > maxDistance) maxDistance = temp;
        }
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() == maxDistance) return horses.get(i);
        }
        return null;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
