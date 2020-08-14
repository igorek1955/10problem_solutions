package CSVwriter;


import com.opencsv.CSVWriter;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class csvWriter_differentApproach {
    static String paramSeparator;
    static char lineSeparator;
    static String filePath;
    static String dateStyle;
    static List<Customer> customers = new ArrayList<>();
    static List<String> rows = new ArrayList<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static DateTimeFormatter formatter;

    public static void main(String[] args) throws IOException {
//        checkInput();
//        fillCustomerList();
//        generateCSV(customers);
    }



    public static void checkInput() throws IOException {
        System.out.println("Укажите разделитель полей: ");
        paramSeparator = reader.readLine();
        if (paramSeparator == null || paramSeparator.isEmpty()) paramSeparator = ",";
        System.out.println("Укажите разделитель записей: ");
        try{
            lineSeparator = reader.readLine().charAt(0);
        } catch (Exception e){
            lineSeparator = '\n';
        }
        System.out.println("Укажите путь к файлу CSV для записи: ");
        filePath = reader.readLine();
        while (true) {
            try {
                System.out.println("Укажите стиль записи даты (e.g.: yyyy MM dd):   ");
                dateStyle = reader.readLine();
                LocalDate date = LocalDate.of(2019, 12, 12);
                formatter = new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .appendPattern(dateStyle)
                        .toFormatter(Locale.ENGLISH);
                date.format(formatter);
                break;
            } catch (Exception e) {
                System.out.println("неверный формат ");
            }
        }
    }

    private static void fillCustomerList() throws IOException {
        System.out.println("Добавляйте пользователей по одному " +
                "в порядке: ID*, Полное имя*, Дата рождения(необязательно)(пример 1991 12 12," +
                " Статус*( .... (данные разделите точкой) ");
        System.out.println("чтобы сохранить результаты в файл введите exit");

        while (true) {
            String s = reader.readLine();
            if (s != null && s.contains("exit")) break;
            String[] c = s.split(",");
            Status.stat status;
            if (c.length == 4) {
                status = switch (c[3]) {
                    case "common" -> Status.stat.COMMON;
                    case "premium" -> Status.stat.PREMIUM;
                    case "paused" -> Status.stat.COLLABORATION_PAUSED;
                    case "canceled" -> Status.stat.COLLABORATION_CANCELED;
                    default -> Status.stat.TEST;
                };
            } else {
                status = switch (c[2]) {
                    case "common" -> Status.stat.COMMON;
                    case "premium" -> Status.stat.PREMIUM;
                    case "paused" -> Status.stat.COLLABORATION_PAUSED;
                    case "canceled" -> Status.stat.COLLABORATION_CANCELED;
                    default -> Status.stat.TEST;
                };
            }
            try {
                LocalDate birth = LocalDate.parse(c[2], formatter);
                customers.add(new Customer(c[0], c[1], birth, status));
            } catch (Exception e) {
                customers.add(new Customer(c[0], c[1], status));
            }
        }
    }


    public static void generateCSV(List<Customer> customers) throws IOException {
        FileWriter csvWriter = new FileWriter("C:\\Users\\Igor\\Desktop\\test7.txt");

        rows.add("ID" + paramSeparator + "Fullname"
                + paramSeparator + "Birthdate"
                + paramSeparator + "Status");
        for (Customer c : customers) {
            if (c.getBirthDate() != null) {
                String birthdate = String.valueOf(c.getBirthDate());
                String stat = String.valueOf(c.getStatus());
                rows.add(c.getCustomerId()
                        + paramSeparator + c.getFullName()
                        + paramSeparator + birthdate
                        + paramSeparator + stat
                        + lineSeparator);
            } else {
                String stat = String.valueOf(c.getStatus());
                rows.add(c.getCustomerId()
                        + paramSeparator + c.getFullName()
                        + paramSeparator + " "
                        + paramSeparator + stat
                        + lineSeparator);
            }
        }

        for(String row: rows){
            csvWriter.append(row);
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
