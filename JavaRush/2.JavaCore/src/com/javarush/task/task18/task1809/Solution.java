package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.next();
        String file2 = scanner.next();

        FileInputStream input = new FileInputStream(file1);
        FileOutputStream output = new FileOutputStream(file2);

        List<Integer> ints = new ArrayList<>();

        while(input.available()>0){
            ints.add(input.read());
        }

        Collections.reverse(ints);


        ints.forEach(b -> {
            try {
                output.write(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        scanner.close();
        input.close();
        output.close();
    }
}
