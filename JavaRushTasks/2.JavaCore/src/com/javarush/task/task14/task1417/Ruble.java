package com.javarush.task.task14.task1417;

public class Ruble extends Money {
    public static final String currency = "RUB";
    double amount;

    public Ruble(double amount) {
        super(amount);
    }

    public String getCurrencyName(){
        return currency;
    }
}
