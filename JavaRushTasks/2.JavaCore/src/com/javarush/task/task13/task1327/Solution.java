package com.javarush.task.task13.task1327;

import java.util.ArrayList;
import java.util.List;

/* 
Репка
*/
//Внучка за Бабку
//Бабка за Дедку
//Дедка за Репку

public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));//0
        plot.add(new Person("Дедка", "Дедку"));//1
        plot.add(new Person("Бабка", "Бабку")); //2
        plot.add(new Person("Внучка", "Внучку"));//3
        RepkaStory.tell(plot);
    }
}
