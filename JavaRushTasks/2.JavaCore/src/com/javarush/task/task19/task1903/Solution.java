package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine" );
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static void main(String[] args) {

        String c = String.valueOf(38);
        String p = String.valueOf(501234567);
        StringBuilder sb = new StringBuilder();
        while(p.length()<10){
            p = 0+p;
        }
        sb.append('+')
                .append(c)
                .append('(')
                .append(p.substring(0,3))
                .append(')')
                .append(p.substring(3,6))
                .append('-')
                .append(p.substring(6,8))
                .append('-')
                .append(p.substring(8));
        System.out.println(sb.toString());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data){
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+ data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            StringBuilder sb = new StringBuilder();
            int c = data.getCountryPhoneCode();
            String p = String.valueOf(data.getPhoneNumber());
            while(p.length()<10){
                p = 0+p;
            }
            sb.append('+')
                    .append(c)
                    .append('(')
                    .append(p.substring(0,3))
                    .append(')')
                    .append(p.substring(3,6))
                    .append('-')
                    .append(p.substring(6,8))
                    .append('-')
                    .append(p.substring(8));
//            sb.append(String.valueOf(data.getCountryPhoneCode())).append(data.getPhoneNumber());
//            while (sb.length()<10){
//                sb.append("0");
//            }
            return sb.toString();
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}