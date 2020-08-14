package CSVwriter;


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


public class csvWriter {
    static String paramSeparator;
    static char lineSeparator;
    static String filePath;
    static String dateStyle;
    static List<Customer> customers = new ArrayList<>();
    static List<List<String>> rows = new ArrayList<List<String>>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static DateTimeFormatter formatter;


    public static void main(String[] args) throws IOException {
        checkInput();
        fillCustomerList();
        generateCSV(customers);
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
            CSVwriter.Status.stat status;
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
        //TODO изменить записть в CSV файл
        try{
            Files.createFile(Path.of(filePath));
        } catch (Exception ignored){
        }
        FileWriter csvWriter = new FileWriter(filePath);
        csvWriter.append("ID");
        csvWriter.append(paramSeparator);
        csvWriter.append("Fullname");
        csvWriter.append(paramSeparator);
        csvWriter.append("Birthdate");
        csvWriter.append(paramSeparator);
        csvWriter.append("Status");
        csvWriter.append(lineSeparator);

        for (Customer c : customers) {
            if (c.getBirthDate() != null) {
                String birthdate = String.valueOf(c.getBirthDate());
                String stat = String.valueOf(c.getStatus());
                rows.add(Arrays.asList(c.getCustomerId(), c.getFullName(), birthdate, stat));
            } else {
                String stat = String.valueOf(c.getStatus());
                rows.add(Arrays.asList(c.getCustomerId(), c.getFullName(), " ", stat));
            }
        }

        for (List<String> rowData : rows) {
            csvWriter.append(String.join(paramSeparator, rowData));
            csvWriter.append(lineSeparator);
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
