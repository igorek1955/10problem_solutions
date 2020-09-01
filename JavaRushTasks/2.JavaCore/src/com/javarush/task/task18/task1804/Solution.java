package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filepath = reader.readLine();
        FileInputStream buffer = new FileInputStream(filepath);


        Map<Integer, Integer> intMap = new HashMap<>();


        intMap.merge(buffer.read(), 1, Integer::sum);

        intMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(Collections.min(intMap.values())))
                .forEach(entry -> System.out.print(entry.getKey() + " "));
        reader.close();
        buffer.close();

    }
}
