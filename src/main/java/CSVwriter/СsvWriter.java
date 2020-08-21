package CSVwriter;


import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;


public class СsvWriter {
    static List<Customer> customers = new ArrayList<>();
    static List<List<String>> rows = new ArrayList<List<String>>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static DateTimeFormatter formatter;

    static class Configuration {
        static String paramSeparator;
        static char lineSeparator;
        static String filePath;
        static String dateStyle;
    }


    public static void main(String[] args) throws IOException {
        checkInput();
//        fillCustomerList();
        generateCustomerList(20);
        generateCSV(customers);
    }

    public static void checkInput() throws IOException {
        System.out.println("Укажите разделитель полей: ");
        Configuration.paramSeparator = reader.readLine();
        if (Configuration.paramSeparator == null || Configuration.paramSeparator.isEmpty())
            Configuration.paramSeparator = ",";
        System.out.println("Укажите разделитель записей: ");
        try {
            Configuration.lineSeparator = reader.readLine().charAt(0);
        } catch (Exception e) {
            Configuration.lineSeparator = '\n';
        }
        System.out.println("Укажите путь к файлу CSV для записи: ");
        Configuration.filePath = reader.readLine();
        while (true) {
            try {
                System.out.println("Укажите стиль записи даты (e.g.: yyyy MM dd):   ");
                Configuration.dateStyle = reader.readLine();
                LocalDate date = LocalDate.of(2019, 12, 12);
                formatter = new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .appendPattern(Configuration.dateStyle)
                        .toFormatter(Locale.ENGLISH);
                date.format(formatter);
                break;
            } catch (Exception e) {
                System.out.println("неверный формат ");
            }
        }
    }


    public static void generateCustomerList(int num) {
        String[] names = {"igor", "vasia", "kolya", "veronika", "marina"
                , "marfa", "olga", "olesya", "kilka", "vobla"};
        for (int i = 0; i < num; i++) {
            int randomAge = (int) (Math.random() * (100 - 5 + 1) + 5);
            int randomName = (int) (Math.random() * 10);
            int randomStatus = (int) (Math.random() * 5);
            LocalDate birthDay = LocalDate.now().minusYears(randomAge);
            String id = "id" + i;
            String name = names[randomName];
            status status = null;

            if (i % 2 == 0) status = CSVwriter.status.PREMIUM;
            else if (i % 3 == 0) status = CSVwriter.status.PREMIUM;
            else if (i % 5 == 0) status = CSVwriter.status.TEST;
            else status = CSVwriter.status.COMMON;

            customers.add(new Customer(id, name, birthDay, status));
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
            status status = null;
            if (c.length == 4) {
                status = switch (c[3]) {
                    case "common" -> CSVwriter.status.COMMON;
                    case "premium" -> CSVwriter.status.PREMIUM;
                    case "paused" -> CSVwriter.status.COLLABORATION_PAUSED;
                    case "canceled" -> CSVwriter.status.COLLABORATION_CANCELED;
                    default -> CSVwriter.status.TEST;
                };
            } else {
                status = switch (c[2]) {
                    case "common" -> CSVwriter.status.COMMON;
                    case "premium" -> CSVwriter.status.PREMIUM;
                    case "paused" -> CSVwriter.status.COLLABORATION_PAUSED;
                    case "canceled" -> CSVwriter.status.COLLABORATION_CANCELED;
                    default -> CSVwriter.status.TEST;
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
        try {
            Files.createFile(Path.of(Configuration.filePath));
        } catch (Exception ignored) {
        }
        FileWriter csvWriter = new FileWriter(Configuration.filePath);
        csvWriter.append("ID");
        csvWriter.append(Configuration.paramSeparator);
        csvWriter.append("Fullname");
        csvWriter.append(Configuration.paramSeparator);
        csvWriter.append("Birthdate");
        csvWriter.append(Configuration.paramSeparator);
        csvWriter.append("Status");
        csvWriter.append(Configuration.lineSeparator);


        for (Customer c : customers) {
            if (c.getBirthDate() != null) {
                String birthdate = String.valueOf(c.getBirthDate());
                String stat = String.valueOf(c.getStatus());

                //форматирование даты
                DateTimeFormatter newFormat = DateTimeFormatter.ofPattern(Configuration.dateStyle);
                String date = LocalDate.parse(birthdate, formatter).format(newFormat);

                rows.add(Arrays.asList(c.getCustomerId(), c.getFullName(), date, stat));
            } else {
                String stat = String.valueOf(c.getStatus());
                rows.add(Arrays.asList(c.getCustomerId(), c.getFullName(), " ", stat));
            }
        }

        for (List<String> rowData : rows) {
            csvWriter.append(String.join(Configuration.paramSeparator, rowData));
            csvWriter.append(Configuration.lineSeparator);
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
