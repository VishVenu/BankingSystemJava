import com.opencsv.bean.util.OpencsvUtils;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Client {

    public int clientID;
    public ArrayList<String> accountID;
    public String name;
    public String phoneNumber;
    public String email;
    public String password;
    public String securityQuestion;
    public String securityAnswer;
    public String postalCode;
    public Date dateOfBirth;

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
        this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
        System.out.print("Enter password: ");
        this.password = in.nextLine();
        System.out.print("Enter security question: ");
        this.securityQuestion = in.nextLine();
        System.out.print("Enter security answer: ");
        this.securityAnswer = in.nextLine();
        Helper.setClientData(this.name, this.phoneNumber, this.email, this.password, this.securityQuestion, this.securityAnswer,
                this.postalCode, this.dateOfBirth);
    }

    public void updateUser() throws ParseException {
        int userInput = 1;
        while (userInput != 9) {
            updateUserMenu();
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
                    break;
                case 4:
                    System.out.print("Enter postal code: ");
                    this.postalCode = in.next();
                    break;
                case 5:
                    System.out.print("Enter date of birth(dd/MM/yyyy): ");
                    this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(in.next());
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
                case 9:
                    System.out.print("User details updated successfully.");
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    break;
            }
        }

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

    public void resetPassword() {
        //add security check here
        this.password = "123";
        System.out.println("Your password has been reset to \"123\".\nPlease use update user option to update your password.");
    }

    public void createAccount() {
        System.out.println("***************************************************");
        System.out.println("Please select one of the below account type:");
        System.out.println("1. Chequing");
        System.out.println("2. Savings");
        System.out.println("3. Exit");
        System.out.println("***************************************************");
        int accountTypeChoice = in.nextInt();
        switch (accountTypeChoice) {
            case 1:
                generateAccountNumber();
                System.out.println("Chequing account created successfully.");
                System.out.println(this.accountID.get(accountID.size()-1));
                break;
            case 2:
                generateAccountNumber();
                System.out.println("Savings account created successfully.");
                System.out.println(this.accountID.get(accountID.size()-1));
                break;
            case 3:
                break;
        }
    }

    private void generateAccountNumber() {
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
        if (!this.accountID.contains(generatedString)) {
            this.accountID.add(generatedString);
        }
    }

    public void loginUser(){
        String usernameInput;
        String passwordInput;
        System.out.println("***************************************************");
        System.out.println("Enter Username:");
        usernameInput = in.next();
        System.out.println("Enter Password:");
        passwordInput = in.next();
        //TO REMOVE
        this.accountID = new ArrayList<>();
        validateUser(usernameInput,passwordInput);

    }

    private void validateUser(String username, String password){
        if(this.name.equals(username) && this.password.equals(password)){
            System.out.println("Login Successful!!");
            //get the user data
        }else{
            System.err.println("Login Failed!!");
        }
    }

    public void performBankingTransactions() {
        System.out.println("***************************************************");
        System.out.println("Please select one of the below banking transactions:");
        System.out.println("1. Debit amount");
        System.out.println("2. Pay bills");
        System.out.println("3. Transfer amount");
        System.out.println("4. Display balance");
        System.out.println("5. Deposit");
        System.out.println("6. Get transaction history");
        System.out.println("7. Exit");
        System.out.println("***************************************************");
        int transactionTypeChoice = in.nextInt();
        switch (transactionTypeChoice) {
            case 7:
                break;
        }
    }
}
