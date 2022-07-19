import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;

public class Helper {
    static String clientCSVFilePath = "BankingSystem/src/clients.csv";
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

    public static void getClientData() {

        List<List<String>> transactions = readFromCSV(clientCSVFilePath);
    };

    public static void setClientData(String name, String phoneNumber, String emailID, String password,
                                     String securityQuestion, String securityAnswer, String postalCode,
                                     Date dateOfBirth) {
        try {
            // create a list of objects
            List<String> client = Arrays.asList(name, phoneNumber, emailID,
                    String.valueOf(dateOfBirth), password,
                    securityQuestion, securityAnswer, postalCode);

            FileWriter writer = new FileWriter("clients.csv");

            // header
            writer.write("Name,PhoneNumber,EmailID,DateOfBirth,Password,SecurityQuestion,SecurityAnswer,PostalCode");

            // write data
            writer.write(String.join(",", client));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String updateAccountData(String accountData){
        return "test";
    }
}

