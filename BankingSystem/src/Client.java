import com.opencsv.bean.util.OpencsvUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client {

    public int clientID;
    public ArrayList<Integer> accountID;
    public  String name;
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
        System.out.print("Enter fullname ");
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
    }

    public void updateUser() throws ParseException{
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

        int userinput = in.nextInt();
        switch(userinput){
            case 1:
                System.out.print("Enter fullname ");
                this.name = in.nextLine();
                break;
            case 2:
                System.out.print("Enter phone number: ");
                this.phoneNumber = in.nextLine();
                break;
            case 3:
                System.out.print("Enter emailID: ");
                this.email = in.nextLine();
                break;
            case 4:
                System.out.print("Enter postal code: ");
                this.postalCode = in.nextLine();
                break;
            case 5:
                System.out.print("Enter date of birth(dd/MM/yyyy): ");
                this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
                break;
            case 6:
                System.out.print("Enter password: ");
                this.password = in.nextLine();
                break;
            case 7:
                System.out.print("Enter security question: ");
                this.securityQuestion = in.nextLine();
                break;
            case 8:
                System.out.print("Enter security answer: ");
                this.securityAnswer = in.nextLine();
                break;
            default:
                return;
        }

    }

    public void resetPassword(){
        //add security check here
        this.password = "123";
        System.out.println("Your password has been reset to \"123\".\nPlease use update user option to update your password.");
    }

    public void createAccount(){
        System.out.println("***************************************************");
        System.out.println("Please select one of the below account type:");
        System.out.println("1. Chequing");
        System.out.println("2. Savings");
        System.out.println("3. Exit");
        System.out.println("***************************************************");
        String accountTypeChoice = in.nextLine();
        switch (accountTypeChoice){
            case "1": //chequing
                System.out.println("Account created successfully.");

                //
                String accountNumber = Helper.updateAccountData("String"); // must generate a random
                //id and sent it back to user, also must append to the
                //list too
                System.out.printf("Account number: %S", accountNumber);
                break;
            case "2": //test
                break;
        }
    }

    public void loginUser(){
        String usernameInput;
        String passwordInput;
        System.out.println("***************************************************");
        System.out.println("LOGIN");
        System.out.println("Username:");
        usernameInput = in.next();
        System.out.println("Password:");
        passwordInput = in.next();
        validateUser(usernameInput,passwordInput);
    }

    private void validateUser(String username, String password){
        if(this.name.equals(username) && this.password.equals(password)){
            System.out.println("Login Successful!!");
        }else{
            System.err.println("Login Failed!!");
        }
    }

    public void performBankingTransactions(){

    }

}
