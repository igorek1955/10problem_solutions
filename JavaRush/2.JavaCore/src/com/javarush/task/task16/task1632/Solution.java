package com.javarush.task.task16.task1632;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        SubThread1 subThread1 = new SubThread1();
        Thread thread1 = new Thread(subThread1);
        threads.add(thread1);
        SubThread2 subThread2 = new SubThread2();
        Thread thread2 = new Thread(subThread2);
        threads.add(thread2);
        SubThread3 subThread3 = new SubThread3();
        Thread thread3 = new Thread(subThread3);
        threads.add(thread3);
        SubThread4 subThread4 = new SubThread4();
        Thread thread4 = new SubThread4();
        threads.add(thread4);
        SubThread5 subThread5 = new SubThread5();
        Thread thread5 = new Thread(subThread5);
        threads.add(thread5);
    }

    public static void main(String[] args) throws InterruptedException {
        for(Thread t: threads){
            t.start();
        }
        Thread.sleep(3000);

        for(int i = 0; i < 3; i++){
            threads.get(i).interrupt();
        }
    }
}


class SubThread1 implements Runnable{
    public void run(){
        while(true){

        }
    }
}

class SubThread2 implements Runnable{
    public void run(){
        try {
            Thread.currentThread().sleep(100000);
        } catch (Exception e) {
            System.out.println("InterruptedException");
        }
    }
}

class SubThread3 implements Runnable{
    public void run(){
        Thread currentThread = Thread.currentThread();
        while(!currentThread.isInterrupted()){
            try {
                System.out.println("Ура");
                currentThread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SubThread4 extends Thread implements Message {
    @Override
    public void run() {
        while(!isInterrupted()) {
        }
    }

    @Override
    public void showWarning() {
        this.interrupt();
    }
}

class SubThread5 implements Runnable{
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> integers = new ArrayList<>();
        while (true) {
            try {
                String s = reader.readLine();
                if (s.equals("N")) break;
                else integers.add(Integer.parseInt(s));
            } catch (IOException ignored) {
            }
        }

        int sum = 0;
        for(Integer i: integers){
            sum+=i;
        }

        System.out.println(sum);
    }
    public void cool(){
        System.out.println("v");
    }
}

