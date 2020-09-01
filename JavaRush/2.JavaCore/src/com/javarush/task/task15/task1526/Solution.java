package com.javarush.task.task15.task1526;

/* 
Дебаг, дебаг, и еще раз дебаг
*/

public class Solution {
    public static void main(String[] args) {
        new B(6);
    }

    private static class A {
        private int f1 = 6;

        private A(int f1) {
            this.f1 = f1;
            initialize();
        }

        private void initialize() {
            System.out.println(f1);
        }
    }

    public static class B extends A {
        private int f1 = 3;

        private B(int f1) {
            super(f1);
            this.f1 += f1;
            initialize();
        }

        private void initialize() {
            System.out.println(f1);
        }
    }
}
