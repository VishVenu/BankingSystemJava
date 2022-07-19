import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Helper {
    static String transactionCSVFilePath = "./files/transactions.csv";
    private static List<List<String>> readFromCSV(String filePath) {
        List<List<String>> records = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));

            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }

            return records;
        } catch (FileNotFoundException e) {
            System.out.println("File not found! " + filePath);
            throw new RuntimeException(e);
        }
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public static void getTransactionData() {

        List<List<String>> transactions = readFromCSV(transactionCSVFilePath);


    };

    public static void setTransactionData(double amount, String eventDescription, TransactionType eventType, String transactionID, LocalDateTime date) {
        try {
            // create a list of objects
            List<String> transaction = Arrays.asList(String.valueOf(transactionID), String.valueOf(date), String.valueOf(eventType), eventDescription, String.valueOf(amount));

            BufferedWriter writer = Files.newBufferedWriter(Path.of(transactionCSVFilePath));

            // header
            writer.write("Id,Date,Type,Description,Amount");
            writer.newLine();

            // write data
            writer.write(String.join(",", transaction));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
