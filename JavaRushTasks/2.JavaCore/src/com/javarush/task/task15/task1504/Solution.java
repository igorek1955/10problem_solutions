package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));

        //объекты передаются по одному из списка books?
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            //как посмотреть где хранятся все созданные объекты и их свойства (Heap) ?
            //у каждого объекта класса наследованного от books, есть своё отдельное свойство books
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";

            if (this instanceof AgathaChristieBook) output = agathaChristieOutput;
            else output = markTwainOutput;
//            if(agathaChristieOutput.contains("Mark Twain") && markTwainOutput.contains("Mark Twain")){
//                output = markTwainOutput;
//            } else {
//                output = agathaChristieOutput;
//            }

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book{
        private String title;

        public MarkTwainBook(String title){
            super("Mark Twain");
            this.title = title;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public static class AgathaChristieBook extends Book{
        private String title;

        public AgathaChristieBook(String title){
            super("Agatha Christie");
            this.title = title;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }
}
