package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static{
        labels.put(12d, "one");
        labels.put(13d, "one");
        labels.put(14d, "one");
        labels.put(15d, "one");
        labels.put(16d, "one");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
