package com.javarush.task.task15.task1519;

import java.io.IOException;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        while(!s.equals("exit")){
            try{
                int i = Integer.parseInt(s);
                if(i > 0 && i < 128){
                    print((short)i);
                } else print(i);
            } catch (Exception e){
                try{
                    print(Double.parseDouble(s));
                } catch (NumberFormatException ee){
                    print(s);
                }
            }
            s = scanner.next();
        }
        scanner.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
