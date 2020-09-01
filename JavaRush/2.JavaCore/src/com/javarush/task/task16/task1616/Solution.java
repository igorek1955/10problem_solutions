package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread{
        private int seconds;

        public void run() {
            Thread current = Thread.currentThread();//Создаем объект для остановки цикла
            try{
                while (!current.isInterrupted()){//тут вызываем метод у объекта останавливающий цикл
                    Thread.sleep(1000);//сон на 1 секс
                    seconds++;// добавляем секунду
                }
            } catch (Exception e){
                System.out.println(seconds);//после выхода из цикла считаем количество секунд
            }
        }
    }
}
