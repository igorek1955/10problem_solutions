package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream input = new FileInputStream(file1);
        FileOutputStream output1 = new FileOutputStream(file2);
        FileOutputStream output2 = new FileOutputStream(file3);
        long total = input.available();
        if (input.available() > 0) {

            if (input.available() % 2 == 0) {
                byte[] buffer1 = new byte[input.available() / 2];
                byte[] buffer2 = new byte[input.available() / 2];
                input.read(buffer1);
                output1.write(buffer1, 0, buffer1.length);
                input.read(buffer2);
                output2.write(buffer2, 0, buffer2.length);
            } else {
                byte[] buffer1 = new byte[input.available()/2 + 1];
                byte[] buffer2 = new byte[input.available() - buffer1.length];
                input.read(buffer1);
                output1.write(buffer1, 0, buffer1.length);
                input.read(buffer2);
                output2.write(buffer2, 0, buffer2.length);
            }
        }
        input.close();
        output1.flush();
        output1.close();
        output2.flush();
        output2.close();
    }
}
