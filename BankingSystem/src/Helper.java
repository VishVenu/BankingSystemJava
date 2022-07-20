import java.io.*;
import java.util.*;

public class Helper {
    static String clientCSVFilePath = "clients.csv";

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

    public static ArrayList<String> getClientData(String email) {

        List<List<String>> clients = readFromCSV(clientCSVFilePath);
        ArrayList<String> activeClient = new ArrayList<>();
        for (List<String> client : clients) {
            if (client.contains(email)) {
                activeClient = (ArrayList<String>) client;
                System.out.println(activeClient);
                break;
            }
        }
        return activeClient;
    }

    ;

    public static void setClientData(String name, String phoneNumber, String emailID,
                                     String dateOfBirth, String password,
                                     String securityQuestion, String securityAnswer, String postalCode) {
        try {
            // create a list of objects
            List<String> client = Arrays.asList(name, phoneNumber, emailID,
                    dateOfBirth, password,
                    securityQuestion, securityAnswer, postalCode);

            FileWriter writer = new FileWriter(clientCSVFilePath, true);

            //avoid duplication
//            // header
//            writer.write("Name,PhoneNumber,EmailID,DateOfBirth,Password,SecurityQuestion,SecurityAnswer,PostalCode");
//            writer.write('\n');
            // write data
            writer.append(String.join(",", client));
            writer.append('\n');
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateClientData(String oldEmail, String name, String phoneNumber, String emailID,
                                        String dateOfBirth,  String password,
                                        String securityQuestion, String securityAnswer, String postalCode) {
        //read from csv first
        List<List<String>> clients = readFromCSV(clientCSVFilePath);
        File file = new File(clientCSVFilePath);
        file.delete();
        //remove all occurence of oldEmail and add new data row again
        for (List<String> client : clients) {
            if (client.contains(oldEmail)) {
                setClientData(name,
                        phoneNumber,
                        emailID,
                        dateOfBirth,
                        password,
                        securityQuestion,
                        securityAnswer,
                        postalCode);
            } else {
                setClientData(client.get(0),
                        client.get(1),
                        client.get(2),
                        client.get(4),
                        client.get(5),
                        client.get(6),
                        client.get(7),
                        client.get(3));
            }
        }
    }

    public static String updateAccountData(String accountData) {
        return "test";
    }
}

