import java.util.Scanner;
import java.time.LocalDateTime;

public class Account {
    public String accno;
    public String name;
    public String acc_type;
    public long balance;

    // Call this method on the required actions. Paybills, withdraw, & deposit.
    Scanner sc = new Scanner(System.in);

//    //method to open new account
//    public void openAccount() {
//        System.out.print("Enter Account No: ");
//        accno = sc.next();
//        System.out.print("Enter Account type: ");
//        acc_type = sc.next();
//        System.out.print("Enter Name: ");
//        name = sc.next();
//        System.out.print("Enter Balance: ");
//        balance = sc.nextLong();
//    }

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
    }

    //method to withdraw money
    public void withdrawAmount() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        debitAmount(amt);
    }

    private void debitAmount(long amt) {
        if (this.balance >= amt) {
            this.balance = this.balance - amt;
            System.out.println("Remaining Balance: " + this.balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    public void transferAmount() {
        System.out.println("Enter the amount of money you would like to transfer: $");
        long moneyToTransfer = sc.nextLong();

        System.out.println("Enter the account number you would like to transfer money to:");
        String toAccount = sc.next();

        debitAmount(moneyToTransfer);

    }

    public void payBills() {
        System.out.println("Enter the recipient account number : $");
        long moneyToTransfer = sc.nextLong();

        debitAmount(moneyToTransfer);

    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showBalance();
            return (true);
        }
        return (false);
    }

    public static void addTransaction(double amount, String eventDescription, TransactionType eventType, String transactionID, String account) {
        LocalDateTime date = LocalDateTime.now();
        Helper.setTransactionData(amount, eventDescription, eventType, transactionID, date, account);
    }


    public static void getTransactionHistory() {
        Helper.getTransactionData();
    }
}

