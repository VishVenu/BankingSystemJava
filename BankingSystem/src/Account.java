import java.time.LocalDateTime;

public class Account {

    // Call this method on the required actions. Paybills, withdraw, & deposit.
    public static void addTransaction(double amount, String eventDescription, TransactionType eventType, String transactionID, String account) {
        LocalDateTime date = LocalDateTime.now();

        Helper.setTransactionData(amount,eventDescription,eventType,transactionID,date, account);
    }

    public static void getTransactionHistory() {
        Helper.getTransactionData();
    }
}
