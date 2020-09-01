package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    private static int eggs;
    private final static String country = "Belarus";

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
