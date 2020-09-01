package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(reader2.readLine()));
        List<String> strings = new ArrayList<>();

        while (reader.ready()) {
            String l = reader.readLine();
            String[] line = l.split(" ");
            for (int i = 0; i < line.length; i++) {
                if (line[i].matches("\\b[0-9]+\\b")) {
                    int c = Integer.parseInt(line[i]);
                    if (c <= 12 && c >0 ) {
                        line[i] = map.get(c);
                    }
                }
            }
            strings.add(String.join(" ", line));
        }

        strings.forEach(System.out::println);
        reader2.close();
        reader.close();

    }


}

