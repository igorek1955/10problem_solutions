package CSVwriter;



import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;



public class csvWriter {
        static String paramSeparator;
        static String lineSeparator;
        static String filePath;
        static String dateStyle;
        static List<CSVwriter.Customer> customers = new ArrayList<>();
        static List<List<String>> rows = new ArrayList<List<String>>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        System.out.println("Укажите разделитель полей: ");
        paramSeparator = reader.readLine();
        if(paramSeparator==null || paramSeparator.isEmpty()) paramSeparator = ",";
        System.out.println("Укажите разделитель записей: ");
        lineSeparator = reader.readLine();
        if(lineSeparator==null || paramSeparator.isEmpty()) paramSeparator = "\n";
        System.out.println("Укажите путь к файлу CSV для записи: ");
        filePath = reader.readLine();
        while(true) {
            try {
                System.out.println("Укажите стиль записи даты (e.g.: yyyy MM dd):   ");
                dateStyle = reader.readLine();
                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .appendPattern(dateStyle)
                        .toFormatter(Locale.ENGLISH);
                LocalDate date = LocalDate.of(2019, 12, 12);
                date.format(formatter);
                break;
            } catch (Exception e) {
                System.out.println("неверный формат ");
            }
        }


        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern(dateStyle)
                .toFormatter(Locale.ENGLISH);


        System.out.println("Добавляйте пользователей по одному " +
                "в порядке: ID*, Полное имя*, Дата рождения(необязательно)," +
                " Статус*( .... (данные разделите точкой) ");
        System.out.println("чтобы сохранить результаты в файл введите exit");

        //create customers in a loop
        while (true) {
            String s = reader.readLine();
            if(s != null && s.contains("exit")) break;
            String[] c = s.split(",");
            CSVwriter.Status.stat status;
            if(c.length == 4) {
                status = switch (c[3]) {
                    case "common" -> CSVwriter.Status.stat.COMMON;
                    case "premium" -> CSVwriter.Status.stat.PREMIUM;
                    case "paused" -> CSVwriter.Status.stat.COLLABORATION_PAUSED;
                    case "canceled" -> CSVwriter.Status.stat.COLLABORATION_CANCELED;
                    default -> CSVwriter.Status.stat.TEST;
                };
            } else{
                status = switch (c[2]) {
                    case "common" -> CSVwriter.Status.stat.COMMON;
                    case "premium" -> CSVwriter.Status.stat.PREMIUM;
                    case "paused" -> CSVwriter.Status.stat.COLLABORATION_PAUSED;
                    case "canceled" -> CSVwriter.Status.stat.COLLABORATION_CANCELED;
                    default -> CSVwriter.Status.stat.TEST;
                };
            }
            try{
                LocalDate birth = LocalDate.parse(c[2], formatter);
                customers.add(new CSVwriter.Customer(c[0], c[1], birth, status));
            } catch (Exception e){
                customers.add(new CSVwriter.Customer(c[0], c[1], status));
            }
        }
        ListsGeneration.generatecsv(customers);
    }


    public static class ListsGeneration{
        public static void generatecsv(List<CSVwriter.Customer> customers) throws IOException {
            FileWriter csvWriter = new FileWriter("C:\\Users\\Igor\\Desktop\\FILE_NAME.txt");
            csvWriter.append("ID");
            csvWriter.append(paramSeparator);
            csvWriter.append("Fullname");
            csvWriter.append(paramSeparator);
            csvWriter.append("Birthdate");
            csvWriter.append(paramSeparator);
            csvWriter.append("Status");
            csvWriter.append('\n');

            for(CSVwriter.Customer c: customers){
                if(c.getBirthDate()!=null){
                    String birthdate = String.valueOf(c.getBirthDate());
                    String stat = String.valueOf(c.getStatus());
                    rows.add(Arrays.asList(c.getCustomerId(), c.getFullName(),birthdate,stat));
                } else{
                    String stat = String.valueOf(c.getStatus());
                    rows.add(Arrays.asList(c.getCustomerId(), c.getFullName()," ",stat));
                }
            }

            for (List<String> rowData : rows) {
                csvWriter.append(String.join(paramSeparator, rowData));
                csvWriter.append('\n');
            }

            csvWriter.flush();
            csvWriter.close();
        }
    }
}
