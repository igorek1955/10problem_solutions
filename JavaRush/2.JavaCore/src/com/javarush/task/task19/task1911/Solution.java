package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream stream1 = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream2 = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream2);
        testString.printSomething();
        String s = outputStream.toString().toUpperCase();
        System.setOut(stream1);
        System.out.println(s);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
