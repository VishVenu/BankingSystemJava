import java.time.LocalDateTime;

enum TransactionType {
    DEBIT,
    CREDIT
}

public class Transaction {
    String transactionID = "";
    LocalDateTime date = LocalDateTime.parse("");
    String eventDescription = "";
    double amount = 0.0;
    TransactionType eventType = TransactionType.CREDIT;
    String account = "" // Chequing, Saving..
}
