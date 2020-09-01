package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            try{
                while(!currentThread.isInterrupted()){
                    for(; numSeconds>0; numSeconds--){
                        System.out.print(numSeconds+" ");
                        currentThread.sleep(1000);
                    }
                }
                System.out.print("Марш!");
            } catch (Exception e){
                System.out.print("Прервано!");
            }


        }
    }
}
