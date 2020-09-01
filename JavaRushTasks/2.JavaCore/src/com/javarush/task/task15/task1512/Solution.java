package com.javarush.task.task15.task1512;

/* 
Максимально простой код-2
*/

import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;

public class Solution {
    public static void main(String[] args) {
        SiamCat simka = new SiamCat("Simka");
        NakedCat nakedSimka = simka.shave();
    }

    public static class NakedCat {
    }

    public static class NormalCat extends NakedCat {
        public NormalCat(String name) {
            System.out.println("My name is " + name);
        }

        public NormalCat(){

        }

        public NakedCat shave() {
            return new NakedCat();
        }
    }

    public static class SiamCat extends NormalCat {
        String name;
        public SiamCat(String name) {
            super(name);
            this.name = name;
        }
    }
}
