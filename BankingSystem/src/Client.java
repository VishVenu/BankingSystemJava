import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Client {

    public int clientID;
    public ArrayList<Account> accounts;
    public String name;
    public String phoneNumber;
    public String email;
    public String password;
    public String securityQuestion;
    public String securityAnswer;
    public String postalCode;
    public String dateOfBirth;

    Scanner in = new Scanner(System.in);

    public void createUser() throws ParseException {
        System.out.println("****Please follow the steps to register as a new user****");
        System.out.print("Enter fullname: ");
        this.name = in.nextLine();
        System.out.print("Enter phone number: ");
        this.phoneNumber = in.nextLine();
        System.out.print("Enter emailID: ");
        this.email = in.nextLine();
        System.out.print("Enter postal code: ");
        this.postalCode = in.nextLine();
        System.out.print("Enter date of birth(dd/MM/yyyy): ");
        this.dateOfBirth = in.nextLine();
        System.out.print("Enter password: ");
        this.password = in.nextLine();
        System.out.print("Enter security question: ");
        this.securityQuestion = in.nextLine();
        System.out.print("Enter security answer: ");
        this.securityAnswer = in.nextLine();
        Helper.setClientData(this.name, this.phoneNumber, this.email, this.dateOfBirth, this.password, this.securityQuestion, this.securityAnswer,
                this.postalCode);
    }

    public void updateUser() throws ParseException {
        int userInput = 1;
        String currentEmail = this.email;
        updateUserMenu();
        while (userInput != 9) {
            userInput = in.nextInt();
            switch (userInput) {
                case 1:
                    System.out.print("Enter fullname: ");
                    this.name = in.next();
                    break;
                case 2:
                    System.out.print("Enter phone number: ");
                    this.phoneNumber = in.next();
                    break;
                case 3:
                    System.out.print("Enter emailID: ");
                    this.email = in.next();
                    if (!Helper.getClientData(this.email).isEmpty()) {
                        this.email = currentEmail;
                        System.err.println("Email already exists. Try another emailID.\n");
                    }
                    break;
                case 4:
                    System.out.print("Enter postal code: ");
                    this.postalCode = in.next();
                    break;
                case 5:
                    System.out.print("Enter date of birth(dd/MM/yyyy): ");
                    this.dateOfBirth = in.next();
                    break;
                case 6:
                    System.out.print("Enter password: ");
                    this.password = in.next();
                    break;
                case 7:
                    System.out.print("Enter security question: ");
                    this.securityQuestion = in.next();
                    break;
                case 8:
                    System.out.print("Enter security answer: ");
                    this.securityAnswer = in.next();
                    break;
//                case 9:
//                    System.out.println("User details updated successfully.");
//                    break;
                default:
                    if (userInput != 9)
                        System.out.println("Please select a valid option.");
                    break;
            }
            updateUserMenu();
        }
        Helper.updateClientData(currentEmail, this.name, this.phoneNumber, this.email, this.dateOfBirth, this.password, this.securityQuestion, this.securityAnswer,
                this.postalCode);
        System.out.println("User details updated successfully.");
    }

    private void updateUserMenu() {
        System.out.println("****Please select the value to update****");
        System.out.println("1. Full name");
        System.out.println("2. Phone number");
        System.out.println("3. EmailID");
        System.out.println("4. Postal code");
        System.out.println("5. Date of birth");
        System.out.println("6. Password");
        System.out.println("7. Security question");
        System.out.println("8. Security answer");
        System.out.println("9. Go back");
    }

    public void resetPassword() throws ParseException {
        System.out.println("\nPlease enter your emailId: ");
        String email = in.next();
        getUserData(email);
        if (this.email != null ) {
            System.out.println(this.securityQuestion);
            System.out.println("\nPlease enter the answer: ");
            String ans = in.next();

            if (this.securityAnswer.contains(ans)){
                this.password = "123";
                System.out.println("Your password has been reset to \"123\".\nPlease use update user option to update your password.");
                Helper.updateClientData(email, this.name, this.phoneNumber, this.email, this.dateOfBirth, this.password, this.securityQuestion, this.securityAnswer,
                        this.postalCode);
            } else {
                System.err.println("Incorrect answer.");
            }
        } else {
            System.err.println("Invalid emailId.");
        }

    }

    public void createAccount() {
        System.out.println("***************************************************");
        System.out.println("Please select one of the below account type:");
        System.out.println("1. Chequing");
        System.out.println("2. Savings");
        System.out.println("3. Exit");
        System.out.println("***************************************************");
        int accountTypeChoice = in.nextInt();
        if(this.accounts==null) {
            this.accounts = new ArrayList<>();
        }
        switch (accountTypeChoice) {
            case 1:
                generateAccountNumber("Chequing");
                System.out.println("Chequing account created successfully.");
                System.out.println(this.accounts.get(accounts.size()-1).accno);
                break;
            case 2:
                generateAccountNumber("Savings");
                System.out.println("Savings account created successfully.");
                System.out.println(this.accounts.get(accounts.size()-1).accno);
                break;
            case 3:
                break;
        }
    }

    private void generateAccountNumber(String accType) {
        int leftLimit = 10;
        // letter 'a'
        int rightLimit = 100;
        // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append(randomLimitedInt);
        }
        String generatedString = buffer.toString();

        Account newAccount = new Account();
        newAccount.name = this.name;
        newAccount.accno = generatedString;
        newAccount.acc_type = accType;
        System.out.print("Enter Balance: ");
        newAccount.balance = in.nextLong();
        this.accounts.add(newAccount);

    }

    public void loginUser() throws ParseException {
        String usernameInput;
        String passwordInput;
        System.out.println("***************************************************");
        System.out.println("Enter Username:");
        usernameInput = in.next();
        System.out.println("Enter Password:");
        passwordInput = in.next();
        validateUser(usernameInput,passwordInput);
        Helper.createNewTransactionFile();
    }

    private void validateUser(String username, String password) throws ParseException {
        //get the user data
        getUserData(username);
        if(this.email.equals(username) && this.password.equals(password)){
            System.out.println("Login Successful!!");
        }else{
            System.err.println("Login Failed!!");
            System.exit(0);
        }
        return;
    }

    public void performBankingTransactions() {
        System.out.println("***************************************************");
        System.out.println("Please select one of the below banking transactions:");
        System.out.println("1. Withdraw amount");
        System.out.println("2. Pay bills");
        System.out.println("3. Transfer amount");
        System.out.println("4. Display balance");
        System.out.println("5. Deposit Amount");
        System.out.println("6. Get transaction history");
        System.out.println("7. Exit");
        System.out.println("***************************************************");
        int transactionTypeChoice = in.nextInt();
        Account chequingAccount=new Account();
        for (Account acc : this.accounts) {
            if (acc.acc_type.equals("Chequing")) {
                chequingAccount = acc;
            }
        }
        if(chequingAccount!=null) {
            switch (transactionTypeChoice) {
                case 1:
                    chequingAccount.withdrawAmount();
                    break;
                case 2:
                    chequingAccount.payBills();
                    break;
                case 3:
                    chequingAccount.transferAmount();
                    break;
                case 4:
                    chequingAccount.showBalance();
                    break;
                case 5:
                    chequingAccount.depositAmount();
                    break;
                case 6:
                    chequingAccount.getTransactionHistory();
                    break;
                case 7:
                    break;
            }

            for (Account acc : this.accounts) {
                if (acc.acc_type.equals("Chequing")) {
                    acc.balance = chequingAccount.balance;
                }
            }

        }
    }

    private void getUserData(String username) throws ParseException {
        ArrayList<String> clientData = Helper.getClientData(username);
        if (clientData.contains(username)){
            this.name = clientData.get(0);
            this.phoneNumber = clientData.get(1);
            this.email = clientData.get(2);
            this.dateOfBirth = clientData.get(3);
            this.password = clientData.get(4);
            this.securityQuestion = clientData.get(5);
            this.securityAnswer = clientData.get(6);
            this.postalCode = clientData.get(7);
        }

    }
}
