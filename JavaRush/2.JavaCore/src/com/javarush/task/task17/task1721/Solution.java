package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException {
        giveTwoFilesAndReadThem();
        checkForDoubles();
        Solution s = new Solution();
        s.joinData();
        System.out.println(allLines.toString());
    }

    private static void checkForDoubles() {

    }

    private static void giveTwoFilesAndReadThem() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = "";
        String f2 = "";
        try {
            f1 = reader.readLine();
            f2 = reader.readLine();
        } catch (IOException e) {
            System.out.println("incorrect filenames\ntry again");
            giveTwoFilesAndReadThem();
        }
        readFiles(f1,f2);
    }

    public void joinData() throws CorruptedDataException {
        allLines.removeAll(forRemoveLines);
        if(!allLines.containsAll(forRemoveLines)) throw new CorruptedDataException();

    }

    public static void readFiles(String f1, String f2){
        try {
            allLines = Files.readAllLines(Paths.get(f1));
            forRemoveLines = Files.readAllLines(Paths.get(f2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


