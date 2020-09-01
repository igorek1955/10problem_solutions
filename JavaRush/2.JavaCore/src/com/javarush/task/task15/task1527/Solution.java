package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] pairs = s.split("&");
        List<Double> doubles = new ArrayList<>();
        int question = s.indexOf("?");
        for (String pair : pairs) {
            int equal = 0;
            if (pair.contains("=")) {
                equal = pair.indexOf("=");
            }

            if (pair.contains("?")) {
                String b = "";
                b = pair.substring(question + 1, equal);
                System.out.print(b + " ");
            } else if (equal == 0) {
                System.out.print(pair + " ");
            } else {
                String b = pair.substring(0, equal);
                System.out.print(b + " ");
            }
        }
        for (String pair : pairs) {
            int equal = 0;
            if (pair.contains("=")) {
                equal = pair.indexOf("=");
            }
            if (pair.contains("obj=")) {
                try {
                    double d = Double.parseDouble(pair.substring(equal + 1));
                    alert(d);
                } catch (Exception e) {
                    alert(pair.substring(equal + 1));
                }
            }
        }
        reader.close();
    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
