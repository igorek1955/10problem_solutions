package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    private static int eggs;
    private final static String country = "Ukraine";

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
