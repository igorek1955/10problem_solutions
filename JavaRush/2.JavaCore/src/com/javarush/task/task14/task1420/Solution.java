package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = 0;
        int num2 = 0;
        int gcd = 1;


        num1 = Integer.parseInt(reader.readLine());
        if(num1<=0) throw new Exception();
        num2 = Integer.parseInt(reader.readLine());
        if(num2<=0) throw new Exception();




        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0)
                gcd = i;
        }

        System.out.println(gcd);
        System.out.println(nod(num1,num2));
        reader.close();
    }

    static int nod(int num1, int num2) {
        return num2 == 0 ? num1 : nod(num2, num1 % num2);}

}
