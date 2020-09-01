package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
        List<Integer> list = new ArrayList<Integer>();
        while(buffer.available()>0) {
            int i = buffer.read();
            if(!list.contains(i)) list.add(i);
        }

        list.stream().sorted().forEach(num-> System.out.print(num+" "));
        scanner.close();
        buffer.close();

    }
}
