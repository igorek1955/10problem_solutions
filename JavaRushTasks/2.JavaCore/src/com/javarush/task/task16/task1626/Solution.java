package com.javarush.task.task16.task1626;

import java.sql.Time;
import java.util.Date;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new CountdownRunnable(), "Уменьшаем").start();
        Thread d = new Thread(new CountUpRunnable(), "Увеличиваем");
        d.start();
        Thread.sleep(2500);
        d.join();
    }

    public static class CountUpRunnable implements Runnable{
        private int countIndexUp = 1;

        @Override
        public void run() {
//            Date start = new Date();
//            System.out.println(start);
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexUp += 1;
                    Thread.sleep(500);
                    if (countIndexUp > Solution.number) break;
//                    Date finish = new Date();
//                    System.out.println(finish.getTime()-start.getTime());
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }


    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
