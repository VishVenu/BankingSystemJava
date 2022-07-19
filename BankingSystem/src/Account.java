import java.time.LocalDateTime;

public class Account {

    public static void addTransaction(double amount, String eventDescription, TransactionType eventType, String transactionID) {
        LocalDateTime date = LocalDateTime.now();


        Helper.setTransactionData(amount,eventDescription,eventType,transactionID,date);

    }

    public static void getTransactionHistory() {
        // Lists the last 3 transactions.
    }

}
