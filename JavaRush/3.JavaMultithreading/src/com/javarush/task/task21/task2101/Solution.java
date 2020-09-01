package com.javarush.task.task21.task2101;

import java.util.Arrays;

/*
Определяем адрес сети
*/
public class Solution {

    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000

    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        String ipBinary = "";
        String maskBinary ="";
        String netBinary="";
        StringBuilder sb = new StringBuilder();
        for(Byte b: ip){
            String s = String.format("%8s", Integer.toBinaryString(b & 0xFF));
            s = s.replace(' ', '0');
            sb.append(s+" ");
        }
        ipBinary = sb.toString();


        StringBuilder sb1 = new StringBuilder();
        for(Byte b: mask){
            String s = String.format("%8s", Integer.toBinaryString(b & 0xFF));
            s = s.replace(' ', '0');
            sb1.append(s+" ");
        }
        maskBinary = sb1.toString();

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 35; i++) {
            char a = ipBinary.charAt(i);
            char b = maskBinary.charAt(i);
            char c = ' ';
            if(a=='1' && b=='1') c = '1';
            else if(a=='0' || b=='0') c = '0';
            sb2.append(String.valueOf(c));
        }
        netBinary = sb2.toString();
        int[] ints = new int[4];
        int num = 0;
        System.out.println(Byte.parseByte("01100110", 2));
        for(String s: netBinary.split("\\s")){
            ints[num] = Integer.parseInt(s,2);
            num++;
        }

        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte)ints[i];
        }
        System.out.println(Arrays.toString(ints));
        return bytes;
    }

    public static void print(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for(Byte b: bytes){
            String s = String.format("%8s", Integer.toBinaryString(b & 0xFF));
            s = s.replace(' ', '0');
            sb.append(s+" ");
        }
        String binary = sb.toString();
        System.out.println(binary);
    }
}
