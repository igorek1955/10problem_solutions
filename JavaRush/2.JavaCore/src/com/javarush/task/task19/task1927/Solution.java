package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream stream1 = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream2 = new PrintStream(byteArrayOutputStream);

        System.setOut(stream2);
        testString.printSomething();
        String s = byteArrayOutputStream.toString();
        System.setOut(stream1);
        System.out.println(s);

    }

    public static class TestString {
//        private int count;
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("JavaRush - курсы Java онлайн");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("JavaRush - курсы Java онлайн");
            System.out.println("fifth");
        }
    }
}
