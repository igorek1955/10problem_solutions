package com.javarush.task.task14.task1417;

public class USD extends Money {
    public static final String currency = "USD";
    double amount;

    public USD(double amount) {
        super(amount);
    }

    public String getCurrencyName(){
        return currency;
    }
}
