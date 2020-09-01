package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;
        private boolean isWinner = true;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            for(String step: OnlineGame.steps) {
                try {
                    if (!OnlineGame.isWinnerFound) {
                        currentThread.sleep(1000 / this.rating);
                        System.out.println(getName() + ":" + step);
                    } else{
                        this.isWinner = false;
                    }
                } catch (Exception e) {
                    System.out.println(this.getName()+":проиграл");
                }
            }
            if(this.isWinner){
                OnlineGame.isWinnerFound = true;
                System.out.println(this.getName()+":победитель!");
            }
        }
    }
}
