package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.printf("Меня зовут %s.\nЯ родился %d.%d.%d",name,d,m,y);
    }
}
