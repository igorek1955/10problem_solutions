package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
        public GenerateThread() throws InterruptedException {
            super(String.valueOf(++Solution.createdThreadCount));
            start();
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }

        public void run(){
            try{
                if(Solution.createdThreadCount<Solution.count){
                    Thread.currentThread().sleep(300);
                    System.out.println(new GenerateThread());
                }
            }catch (Exception ignored){}
        }
    }
}
