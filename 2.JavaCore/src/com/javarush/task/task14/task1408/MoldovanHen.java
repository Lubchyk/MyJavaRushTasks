package com.javarush.task.task14.task1408;

/**
 * Created by АНТ on 26.02.2017.
 */
public class MoldovanHen extends Hen implements Country{
    public  String getDescription() {
        String s = super.getDescription();
        s = s + " Моя страна - " + MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return s;
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return 3;
    }
}