import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.UUID;

public class Account {
    public String accno;
    public String name;
    public String acc_type;
    public long balance;

    // Call this method on the required actions. Paybills, withdraw, & deposit.
    Scanner sc = new Scanner(System.in);

    //method to display account details
    public void showBalance() {
        System.out.println("Name of account holder: " + this.name);
        System.out.println("Account no.: " + this.accno);
        System.out.println("Account type: " + this.acc_type);
        System.out.println("Balance: " + this.balance);
    }

    //method to deposit money
    public void depositAmount() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        this.balance = this.balance + amt;
        System.out.println("Transaction successful!!");
        System.out.println("New Balance: " + this.balance);
        addTransaction(this.balance,"Deposit Amount",TransactionType.CREDIT,this.acc_type);
    }

    //method to withdraw money
    public void withdrawAmount() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        debitAmount(amt);
        addTransaction(this.balance,"Withdraw Amount",TransactionType.DEBIT,this.acc_type);
    }

    private void debitAmount(long amt) {
        if (this.balance >= amt) {
            this.balance = this.balance - amt;
            System.out.println("Transaction successful!!");
            System.out.println("Remaining Balance: " + this.balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
        addTransaction(this.balance,"Debit Amount",TransactionType.DEBIT,this.acc_type);
    }

    public void transferAmount() {
        System.out.println("Enter the amount of money you would like to transfer: $");
        long moneyToTransfer = sc.nextLong();

        System.out.println("Enter the account number you would like to transfer money to:");
        String toAccount = sc.next();

        debitAmount(moneyToTransfer);

        addTransaction(this.balance,"Transfer Amount",TransactionType.DEBIT,this.acc_type);
    }

    public void payBills() {
        System.out.println("Enter the recipient account number : $");
        String toAccount = sc.next();
        System.out.println("Enter the bill amount:");
        long billAmount = sc.nextLong();

        debitAmount(billAmount);

        addTransaction(this.balance,"Pay bills",TransactionType.DEBIT,this.acc_type);
    }

    public void addTransaction(long amount, String eventDescription, TransactionType eventType, String account) {
        UUID uuid = UUID.randomUUID();
        String transactionID = uuid.toString();
        LocalDateTime date = LocalDateTime.now();
        Helper.setTransactionData(amount, eventDescription, eventType, transactionID, date, account);
    }

    public void getTransactionHistory() {
        Helper.getTransactionData();
    }
}

