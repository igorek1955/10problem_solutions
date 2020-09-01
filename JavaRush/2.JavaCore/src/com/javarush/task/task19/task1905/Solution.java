package com.javarush.task.task19.task1905;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        String phone = "+38(050)123-45-67";
        phone = phone.replaceAll("[^+\\d]","");
        System.out.println(phone);
    }


    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryCode = "";
            String name = customer.getCountryName();
            for(Map.Entry<String,String> pair: countries.entrySet()){
                if(pair.getValue().equals(name))countryCode=pair.getKey();
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] lastFirst = contact.getName().split(" ");
            return lastFirst[1].trim();
        }

        @Override
        public String getContactLastName() {
            String[] lastFirst = contact.getName().split(" ");
            return lastFirst[0].trim().substring(0,lastFirst[0].length()-1);
        }

        @Override
        public String getDialString() {
            String phone = contact.getPhoneNumber();
            char[] chars = phone.toCharArray();

            StringBuilder sb = new StringBuilder();

            for(char ch: chars){
                if(ch!='('&&ch!=')'&&ch!='-'){
                    sb.append(ch);
                }
            }
            return "callto://"+sb.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}