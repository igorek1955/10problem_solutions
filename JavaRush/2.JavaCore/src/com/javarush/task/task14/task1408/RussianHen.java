package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    public static int eggs = 0;
    private final static String country = "Russia";

    @Override
    public int getCountOfEggsPerMonth() {
        return eggs;
    }

    @Override
    public String getDescription(){
        return super.getDescription()
                + " Моя страна - "
                + country
                + ". Я несу "
                + eggs
                + " яиц в месяц.";
    }
}
